package Collections.Set.HashSetExample;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SimpleHashSetExample {
    public static void main(String[] args) {
        // 1. Create a HashSet
        // Characteristics:
        // - No duplicates allowed
        // - Order is NOT guaranteed (it uses hashing)
        // - Allows one null value
        Set<String> fruits = new HashSet<>();

        // 2. Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        // 3. Try to add a duplicate
        boolean isAdded = fruits.add("Apple"); // Returns false
        System.out.println("Was duplicate 'Apple' added? " + isAdded);

        // 4. Add a null value
        fruits.add(null);

        // 5. Display the Set
        System.out.println("HashSet: " + fruits);

        // 6. Check if an element exists
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the set.");
        }

        // 7. Remove an element
        fruits.remove("Orange");
        System.out.println("After removing Orange: " + fruits);

        // 8. Iterate over the Set
        System.out.println("\n--- Iterating ---");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 9. Get the size
        System.out.println("\nSize of set: " + fruits.size());

        // 10. Clear the set
        fruits.clear();
        System.out.println("Is set empty? " + fruits.isEmpty());
    }
}
