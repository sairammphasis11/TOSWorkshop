package com.company.cyclic;


/*
Implementing the Phaser and its methods
 */
class PhaserTask implements Runnable{
    @Override
    public void run() {

        System.out.println(Thread.currentThread());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class PhaserApp{
    public static void main(String[] args) {

    }

}
