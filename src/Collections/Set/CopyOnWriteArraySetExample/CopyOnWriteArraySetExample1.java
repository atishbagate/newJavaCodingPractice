package Collections.Set.CopyOnWriteArraySetExample;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample1 {
    public static void main(String[] args) {

        // 1. Create a CopyOnWriteArraySet
        Set<String> listeners = new CopyOnWriteArraySet<>();

        // 2. Add elements
        listeners.add("Listener A");
        listeners.add("Listener B");
        listeners.add("Listener C");

        // 3. Iterate while modifying (Safe!)
        // In a normal HashSet, this would throw ConcurrentModificationException
        System.out.println("--- Iterating and Modifying ---");
        Iterator<String> iterator = listeners.iterator();

        while (iterator.hasNext()) {
            String listener = iterator.next();
            System.out.println("Processing: " + listener);

            if (listener.equals("Listener B")) {
                // This modification will NOT be reflected in the current iterator
                // but will be present in the set for future iterations.
                listeners.add("Listener D (New)");
                listeners.remove("Listener A");
            }
        }

        // 4. Check the final state
        System.out.println("\n--- Final Set ---");
        System.out.println(listeners);
        // Output will show Listener A removed and Listener D added.

    }
}
