package com.company.cyclic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

class PhaserTask implements Runnable{
    Phaser phaser;

    @Override
    public void run() {

        System.out.println(Thread.currentThread());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // phaser.awa

    }

}

public class PhaserApp{
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(3);
        //java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(3);
//        service.execute(new CyclicTask(phaser));
//        service.execute(new CyclicTask(phaser));
//        service.execute(new CyclicTask(phaser));

        // CountDownLatch latch = new CountDownLatch();
        System.out.println("Shutdown Initiated");
        service.shutdown();
        System.out.println("Shutdown Done");

    }

}
