package MultiThreading.CompletableFuture;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public class ExceptionalHandling {
    public static void main(String[] args) {
        int patientAge = -2; // invalid age.

        CompletableFuture<Serializable> labTask = CompletableFuture.supplyAsync(() -> {
            if (patientAge < 0) {
                return new IllegalArgumentException("Age cannot be negative");
            }
            return "Valid age : " + patientAge;
        }).exceptionally(ex -> {
            //cathes any excepion throw above and return fallback value.
            System.out.println("Exception caught" + ex.getMessage());
            return "fallback ";
        });
        System.out.println("res " + labTask.join());
    }
}
