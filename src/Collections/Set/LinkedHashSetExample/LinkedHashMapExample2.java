package Collections.Set.LinkedHashSetExample;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashMapExample2 {

    public static void main(String[] args) {
        // 1. Create a LinkedHashSet
        // Characteristics:
        // - No duplicates allowed
        // - Maintains Insertion Order
        Set<String> visitedPages = new LinkedHashSet<>();

        // 2. Add elements (Simulating user browsing history)
        visitedPages.add("Home");
        visitedPages.add("Products");
        visitedPages.add("About Us");
        visitedPages.add("Contact");

        // 3. Try to add a duplicate (User visits 'Home' again)
        // It won't be added, and the order won't change (it stays at the first position)
        boolean isAdded = visitedPages.add("Home");
        System.out.println("Was 'Home' added again? " + isAdded);

        // 4. Display the Set
        // Notice the order is exactly as inserted: Home, Products, About Us, Contact
        System.out.println("Visited Pages (Insertion Order): " + visitedPages);

        // 5. Remove an element
        visitedPages.remove("Products");
        System.out.println("After removing 'Products': " + visitedPages);

        // 6. Iterate
        System.out.println("\n--- Iterating ---");
        for (String page : visitedPages) {
            System.out.println(page);
        }

    }
}
