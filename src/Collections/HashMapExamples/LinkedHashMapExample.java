package Collections.HashMapExamples;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // 1. Create a LinkedHashMap
        // This guarantees that when we loop through it, items come out in the order we put them in.
        LinkedHashMap<String, String> userJourney = new LinkedHashMap<>();

        // 2. Add entries (Insertion Order)
        userJourney.put("Step 1", "Login Page");
        userJourney.put("Step 2", "Dashboard");
        userJourney.put("Step 3", "Add to Cart");
        userJourney.put("Step 4", "Checkout");
        userJourney.put("Step 5", "Payment Success");

        // 3. Iterate and display
        System.out.println("--- User Journey (Order is Guaranteed) ---");

        for (Map.Entry<String, String> entry : userJourney.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Note: If this was a regular HashMap, "Step 4" might appear before "Step 1"
        // because HashMap sorts based on hash codes, not time of insertion.
    }
}
