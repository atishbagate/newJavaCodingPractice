package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ChainingCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            // step 1 : supply data ( Async source )
            System.out.println("Step 1 : Fetching billing units.");
            return 150;
        }).thenApply(units -> {
            System.out.println("Step 2 : change amount.");
            return units * 12.5;
        }).thenAccept(total -> {
            System.out.println("Step 3 : final bill amount : $ " + total);
        }).thenRun(() -> {
            System.out.println("Step 4 :  billing done");
        }).join();

    }
}
