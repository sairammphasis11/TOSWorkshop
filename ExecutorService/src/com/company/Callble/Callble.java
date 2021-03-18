package com.company.Callble;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Emp{

    public int empid,empnmbr;

    @Override
    public String toString() {
        return "Emp{" +
                "empid=" + empid +
                ", empnmbr=" + empnmbr +
                '}';
    }

    public Emp(int empid, int empnmbr) {
        this.empid = empid;
        this.empnmbr = empnmbr;
    }
}
class runr implements Callable<Emp> {

    int p1 ,p2;
    String name;

    public runr(int p1, int p2, String name) {
        this.p1 = p1;
        this.p2 = p2;
        this.name = name;
    }

    @Override
    public Emp call() throws Exception {
        System.out.println(Thread.currentThread()+""+name);
        return new Emp(p1,p2);
    }
}


public class Callble {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future> futureList = new ArrayList<Future>();
        for ( int i=0 ; i<10 ; i++) {
            Future<Emp> future = service.submit(new runr( i+1, i+1 , "Task"+i+1 ));
            futureList.add((future));
        }
        for (Future<Emp> future: futureList) {
            Emp emp = future.get();
            System.out.println(emp);

        }
        service.shutdown();
    }
}
