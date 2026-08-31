package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CreationOfCompletableFuture {
    public static void main(String[] args) {

        // 1. Task without return value
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Thread run Async : " + Thread.currentThread().getName());
        });

        // 2. Task with return value
        CompletableFuture<Void> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync : " + Thread.currentThread().getName());
            return 10;
        }).thenAccept(System.out::println);

        // 3. Wait for all background tasks to finish before main exits
        CompletableFuture.allOf(voidCompletableFuture, integerCompletableFuture).join();

    }
}
