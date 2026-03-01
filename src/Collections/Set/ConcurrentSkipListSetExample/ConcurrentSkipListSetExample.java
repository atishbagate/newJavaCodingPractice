package Collections.Set.ConcurrentSkipListSetExample;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetExample {
    public static void main(String[] args) {
        // 1. Create a ConcurrentSkipListSet
        // Characteristics:
        // - Thread-safe
        // - Sorted (Natural ordering or Comparator)
        // - Non-blocking reads
        ConcurrentSkipListSet<String> sortedSet = new ConcurrentSkipListSet<>();

        // 2. Add elements
        sortedSet.add("Banana");
        sortedSet.add("Apple");
        sortedSet.add("Cherry");
        sortedSet.add("Date");

        // 3. Display (Sorted Order)
        System.out.println("Initial Set: " + sortedSet);

        // 4. Concurrent Modification
        // We can iterate and modify at the same time without ConcurrentModificationException
        System.out.println("\n--- Iterating and Modifying ---");
        Iterator<String> iterator = sortedSet.iterator();

        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Processing: " + fruit);

            if (fruit.equals("Banana")) {
                // Add a new element while iterating
                // Unlike CopyOnWriteArraySet, this MIGHT appear in the current iteration
                // because it's a weakly consistent iterator.
                sortedSet.add("Elderberry");
                System.out.println("-> Added Elderberry");
            }
        }

        // 5. Final State
        System.out.println("\nFinal Set: " + sortedSet);

        // 6. Navigation Methods (Similar to TreeSet)
        System.out.println("\nFirst Element: " + sortedSet.first());
        System.out.println("Last Element: " + sortedSet.last());
        System.out.println("Element higher than 'Banana': " + sortedSet.higher("Banana"));
    }
}
