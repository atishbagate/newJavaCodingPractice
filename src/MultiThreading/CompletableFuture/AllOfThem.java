package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class AllOfThem {
    public static void main(String[] args) {

        // Task 1: Fetch patient personal info
        CompletableFuture<String> patientTask = CompletableFuture.supplyAsync(() -> {
            return "Patient: John Doe";
        });

        // Task 2: Fetch patient lab results
        CompletableFuture<String> labTask = CompletableFuture.supplyAsync(() -> {
            return "Lab: Blood Test Normal";
        });

        // Task 3: Fetch patient billing info
        CompletableFuture<String> billingTask = CompletableFuture.supplyAsync(() -> {
            return "Billing: Balance $0";
        });

        // Wait for all 3 tasks to complete together
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(patientTask, labTask, billingTask);
        // Block until all are done
        allTasks.join();

        // Extract individual results safely (since all are finished)
        System.out.println(patientTask.join());
        System.out.println(labTask.join());
        System.out.println(billingTask.join());

    }
}
