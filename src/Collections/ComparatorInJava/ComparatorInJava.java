package Collections.ComparatorInJava;

import java.util.ArrayList;
import java.util.Comparator;

// Step 1: Traditional way - Creating a separate class that implements Comparator
class compareById implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) { // Returns negative if a < b, 0 if equal, positive if a > b
        return a - b;
    }
}

public class ComparatorInJava {
    public static void main(String[] args) {
        ArrayList<Integer> listOfId = new ArrayList<>();
        listOfId.add(1);
        listOfId.add(6);
        listOfId.add(2);
        listOfId.add(5);
        // Step 1: Using the custom Comparator class
        listOfId.sort(new compareById());
        System.out.println("List sorted (Class): " + listOfId);
        // Step 2: Using Anonymous Inner Class (Pre-Java 8 style)
        // Useful for one-time use comparators
        listOfId.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // Logic for descending order
            }
        });
        System.out.println("List sorted (Anonymous Class Descending): " + listOfId);
        // Step 3: Using Lambda Expression (Java 8+)
        // Much more concise syntax for the same logic
        listOfId.sort((a, b) -> a - b);
        System.out.println("List sorted (Lambda Ascending): " + listOfId);

        // Step 4: Using Comparator static methods
        // Java provides built-in comparators for common needs
        listOfId.sort(Comparator.reverseOrder());
        System.out.println("List sorted (Comparator.reverseOrder): " + listOfId);
    }
}
