package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class AnyOfExample {
    public static void main(String[] args) {
        // Server 1: Simulates 300 ms response time
        CompletableFuture<String> server1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Response from Server 1 (300ms)";
        });

        // Server 2: Simulates 100 ms response time (Fastest)
        CompletableFuture<String> server2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Response from Server 2 (100ms)";
        });

        // Server 3: Simulates 500 ms response time
        CompletableFuture<String> server3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Response from Server 3 (500ms)";
        });

        // anyOf triggers as soon as the first task finishes
        CompletableFuture<Object> fastestResponse = CompletableFuture.anyOf(server1, server2, server3);

        // Print the fastest result
        System.out.println("First to respond: " + fastestResponse.join());
    }
}
