package Collections.HashMapExamples;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {
    public static void main(String[] args) {

        Map<String, String> identityHashMap = new IdentityHashMap<>();

        String key1 = new String("key");
        String key2 = new String("key");

        // 2. Create two distinct String objects with the same content
        // Note: We use 'new String()' to force new object creation, bypassing the string pool.
        identityHashMap.put(key1, "value1");
        identityHashMap.put(key2, "value2");

        // 4. Check size
        // In a normal HashMap, size would be 1 because key1.equals(key2) is true.
        // In IdentityHashMap, size is 2 because key1 == key2 is false.
        System.out.println("Size of IdentityHashMap: " + identityHashMap.size());

        // 5. Retrieve values
        System.out.println("Value for key1: " + identityHashMap.get(key1));
        System.out.println("Value for key2: " + identityHashMap.get(key2));

    }
}
