package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CombiningTwoTasks {
    public static void main(String[] args) {

        // Task 1: Fetch patient data asynchronously
        CompletableFuture<String> patientDetailsFuture = CompletableFuture.supplyAsync(() -> {
            return "Patient: John Doe (ID: 9941)";
        });

        // Task 2: Fetch lab report asynchronously
        CompletableFuture<String> labTask = CompletableFuture.supplyAsync(() -> {
            return "Lab Report: Normal Blood Sugar";
        });

        // Combine Task 1 and Task 2 using thenCombine
        CompletableFuture<String> combinedReport = patientDetailsFuture.thenCombine(labTask, (details, lab) -> details + " | " + lab);

        // waiting for both tasks to finish and get the combined result.
        System.out.println("Patient Details: " + combinedReport.join());
    }
}
