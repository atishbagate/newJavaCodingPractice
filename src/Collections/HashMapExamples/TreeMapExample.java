package Collections.HashMapExamples;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // 1. Create a TreeMap (Sorts keys naturally - Ascending Order)
        TreeMap<Integer, String> scores = new TreeMap<>();

        // 2. Add entries (Order doesn't matter here, TreeMap sorts them automatically)
        scores.put(90, "Alice");
        scores.put(50, "Bob");
        scores.put(10, "Charlie");
        scores.put(80, "David");

        // 3. Iterate (Will be printed in ascending order of keys: 10, 50, 80, 90)
        System.out.println("--- Sorted by Score (Natural Order) ---");
        for (Map.Entry<Integer, String> entry : scores.entrySet()) {
            System.out.println("Score: " + entry.getKey() + " - " + entry.getValue());
        }

        // 4. Navigation Methods (Unique to TreeMap/NavigableMap)
        System.out.println("\n--- Navigation Methods ---");
        System.out.println("First Key (Lowest): " + scores.firstKey());
        System.out.println("Last Key (Highest): " + scores.lastKey());

        // Find the key closest to 45 (less than or equal to)
        System.out.println("Floor Key of 45 (<= 45): " + scores.floorKey(45)); // Output: 10

        // Find the key closest to 45 (greater than or equal to)
        System.out.println("Ceiling Key of 45 (>= 45): " + scores.ceilingKey(45)); // Output: 50

        // 5. Custom Comparator Example (Reverse Order)
        System.out.println("\n--- Custom Comparator (Reverse Order) ---");
        TreeMap<String, Integer> reverseMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
        reverseMap.put("Apple", 1);
        reverseMap.put("Banana", 2);
        reverseMap.put("Cherry", 3);

        for (Map.Entry<String, Integer> entry : reverseMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        // Output: Cherry, Banana, Apple
    }
}
