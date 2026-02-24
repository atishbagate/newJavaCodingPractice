package Collections.List.CopyOnArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Add elements
        list.add("Java");
        list.add("Python");
        list.add("C++");

        System.out.println("Initial List: " + list);

        // Demonstrate concurrent modification during iteration
        // In a normal ArrayList, modifying the list while iterating would throw ConcurrentModificationException
        System.out.println("\nIterating and modifying...");
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String language = iterator.next();
            System.out.println("Reading: " + language);

            if (language.equals("Java")) {
                // This modification will NOT be reflected in the current iterator
                // and will NOT throw ConcurrentModificationException
                list.add("Golang");
                System.out.println("  -> Added 'Golang' to the list while iterating.");
            }

            if (language.equals("Python")) {
                list.remove("C++");
                System.out.println("  -> Removed 'C++' from the list while iterating.");
            }
        }

        // Show the final list
        System.out.println("\nFinal List: " + list);
    }
}
