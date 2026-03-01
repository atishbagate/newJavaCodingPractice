package Collections.HashMapExamples;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

    public static void main(String[] args) {
        // creation
        Map<Object, String> weakMap = new WeakHashMap<>();

        // 2. Create a key object
        // Note: We must not use a String literal (e.g., "key") because Java pools strings
        // and they are almost never garbage collected. We need a new object.
        Object key = new Object();
        String value = "String value for key";

        weakMap.put(key, value);
        System.out.println("map before GC " + weakMap);

        // 3. Remove the strong reference to the key
        // Now the ONLY reference to this object is the weak one inside the map.
        key = null;

        System.gc();
        // 6. Check the map
        // If GC ran, the entry should be gone!
        System.out.println("map after GC " + weakMap);

    }
}
