import java.util.concurrent.CompletableFuture;

public class CompletableClass {

    public static void main(String[] args) {

    CompletableFuture<Integer> cf = new CompletableFuture<>();
    process(cf);
    cf.complete(4);
        System.out.println("EMD");

 }


   public static void  process(CompletableFuture<Integer> cf){

        cf.thenApply(el -> el/0)
                .exceptionally(throwable-> handle(throwable))
                .thenAccept(System.out::println);


    }

    private static Integer handle(Throwable throwable) {

        System.out.println(throwable);
        return 3;
    }

}
