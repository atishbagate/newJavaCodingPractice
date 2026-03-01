package Collections.HashMapExamples;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapAccessOrderExample {
    public static void main(String[] args) {
        // 1. Create LinkedHashMap with accessOrder = true
        // The third argument 'true' enables access order mode.
        // 16 is default initial capacity, 0.75f is default load factor.
        LinkedHashMap<String, String> accessMap = new LinkedHashMap<>(16, 0.75f, true);

        // 2. Add entries
        accessMap.put("A", "Apple");
        accessMap.put("B", "Banana");
        accessMap.put("C", "Cherry");

        System.out.println("--- Initial Order (Insertion Order) ---");
        printMap(accessMap);

        // 3. Access "A" (get)
        // In accessOrder mode, accessing an element moves it to the end of the iteration order.
        System.out.println("\nAccessed key 'A': " + accessMap.get("A"));
        // Expected Order: B, C, A

        // 4. Access "B" (get)
        System.out.println("Accessed key 'B': " + accessMap.get("B"));
        // Expected Order: C, A, B

        // 5. Iterate and display to show the new order
        System.out.println("\n--- Final Order (Access Order / LRU behavior) ---");
        // The first element printed is the Least Recently Used (LRU)
        // The last element printed is the Most Recently Used (MRU)
        printMap(accessMap);
    }

    private static void printMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
