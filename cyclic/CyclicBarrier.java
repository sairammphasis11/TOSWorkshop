

package com.company.cyclic;

        import java.util.concurrent.BrokenBarrierException;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

class CyclicTask implements Runnable{

    java.util.concurrent.CyclicBarrier barrier;
    public CyclicTask(java.util.concurrent.CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        System.out.println("Thread waits");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Barrier ends");
    }
}


public class CyclicBarrier {


    public static void main(String[] args) {

        ExecutorService service= Executors.newFixedThreadPool(4);
        java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(3);
        service.execute(new CyclicTask(cyclicBarrier));
        service.execute(new CyclicTask(cyclicBarrier));
        service.execute(new CyclicTask(cyclicBarrier));

        // CountDownLatch latch = new CountDownLatch();
        System.out.println("Shutdown Initiated");
        service.shutdown();
        System.out.println("Shutdown Done");
    }
}

