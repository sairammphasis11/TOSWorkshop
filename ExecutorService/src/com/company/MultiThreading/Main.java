package com.company.MultiThreading;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class runner implements Runnable{


    @Override
    public void run()  {
        Logger logger  = Logger.getLogger(Main.class.getName());
        logger.log(Level.INFO,"MAIN");
        System.out.println(Thread.currentThread());
    }
}
public class Main {

    public static void main(String[] args) {
        Logger logger  = Logger.getLogger(Main.class.getName());
        logger.log(Level.INFO,"MAIN");
       ScheduledExecutorService se= Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()) ;
       se.schedule(new runner(),5, TimeUnit.SECONDS);

       /* ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for(int i = 0 ; i<10 ; i++){
            executorService.execute(new runner());
        }*/
	// write your code here
    }
}
