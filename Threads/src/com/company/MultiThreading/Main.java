package com.company.MultiThreading;

class Food {


    private int amt;

    public void getAmt() {
        //this.amt--;
        System.out.println(amt);
    }

    public void setAmt(int amt) {
        this.amt = amt;
        System.out.println(amt);
    }
}

class Runner implements  Runnable{

    Food food;

    Runner(){

        food =new Food();
    }

    @Override
    public void run() {
        Thread thread =Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread());

            if(thread.getName() == "Producer"){
                synchronized (food){
                    try {
                        food.notify();
                        food.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    food.setAmt(i+1);
                }

            }else{
                synchronized (food) {
                    try {
                        food.notify();
                        food.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    food.getAmt();
                }
            }

        }
    }
}

public class Main {

    public static void main(String[] args) {

        Thread mainT = Thread.currentThread();

        System.out.println(mainT.getName());
        Runner runner = new Runner();
        Thread thread1 =  new Thread(runner,"Producer");
        thread1.start();
        System.out.println(thread1.getState());
        Thread thread2 = new Thread(runner,"Consumer");
        thread2 .start();

        try {
            mainT.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());


        // write your code here
    }
}
