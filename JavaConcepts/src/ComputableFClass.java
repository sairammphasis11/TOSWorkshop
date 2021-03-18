import java.util.concurrent.CompletableFuture;


//Completable Future Class
public class ComputableFClass {

    public static void main(String[] args) {

        //task(88).thenAccept(value -> print(value));//foreach
            task(20).thenCombine(task(22),(result1, result2)-> result1+result2)
                    .thenAccept(System.out::println);//reduce

    }

    public static int sumCompute(int nmbr){
        System.out.println("Inside sumCompute : "+Thread.currentThread());
        return nmbr;
    }

    public static CompletableFuture<Integer> task(int nmbr){
        return CompletableFuture.supplyAsync(()->sumCompute(nmbr));
    }

    public static void print(int data){
        System.out.println("Inside print : "+Thread.currentThread());

        System.out.println(data);
    }

}
