package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStream {

    public static void main(String[] args) {

        List<Shares> sharesList = new ArrayList<Shares>();
        sharesList.add(new Shares(11, "Sairam", "2000"));
        sharesList.add(new Shares(21, "Venkat", "2000"));
        sharesList.add(new Shares(31, "Sandeep", "7656"));
        List<Integer> nmbr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        PerfMonitor.task(() -> System.out.println(nmbr.stream()
                .filter(el -> el % 2 == 0)
                .mapToInt(ParallelStream::compute)
                .sum()));
        PerfMonitor.task(() -> System.out.println(nmbr.parallelStream()
                .filter(el -> el % 2 == 0)
                .mapToInt(ParallelStream::compute)
                .sum()));


    }

    public static int compute(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i * 2;
    }


}

class PerfMonitor {


    public static void task(Runnable task) {
    long start = System.currentTimeMillis();
        try{

        task.run();

    }finally {
        long end = System.currentTimeMillis();
            System.out.println("Time takenis" + (end-start)/1.0e9);
    }

    }

}

class Shares {
    private int shId;
    private String shName;
    private String shAmt;

    @Override
    public String toString() {
        return "Shares{" +
                "shId=" + shId +
                ", shName='" + shName + '\'' +
                ", shAmt='" + shAmt + '\'' +
                '}';
    }

    public int getShId() {
        return shId;
    }

    public void setShId(int shId) {
        this.shId = shId;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName;
    }

    public String getShAmt() {
        return shAmt;
    }

    public void setShAmt(String shAmt) {
        this.shAmt = shAmt;
    }

    public Shares(int shId, String shName, String shAmt) {
        this.shId = shId;
        this.shName = shName;
        this.shAmt = shAmt;
    }
}
