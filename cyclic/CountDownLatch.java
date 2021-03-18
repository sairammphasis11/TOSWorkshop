package com.company.cyclic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
    java.util.concurrent.CountDownLatch latch;

    public Task(java.util.concurrent.CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        latch.countDown();
    }
}


public class CountDownLatch {


    public static void main(String[] args) {

       ExecutorService service= Executors.newFixedThreadPool(4);
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(3);

        service.execute(new Task(latch));
        service.execute(new Task(latch));
        service.execute(new Task(latch));
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // CountDownLatch latch = new CountDownLatch();

        service.shutdown();
    }
}
