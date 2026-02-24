package Collections.List.VectorExample;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        System.out.println("this is vector example");

        // Create a Vector
        Vector<String> vector = new Vector<>();

        // Add elements using add()
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");
        System.out.println("Vector after adding elements: " + vector);

        // Add element at specific index
        vector.add(1, "Grapes");
        System.out.println("Vector after adding 'Grapes' at index 1: " + vector);

        // Get element using get()
        String firstElement = vector.get(0);
        System.out.println("Element at index 0: " + firstElement);

        // Update element using set()
        vector.set(2, "Mango");
        System.out.println("Vector after setting index 2 to 'Mango': " + vector);

        // Check if vector contains an element using contains()
        boolean hasApple = vector.contains("Apple");
        System.out.println("Does vector contain 'Apple'? " + hasApple);

        // Remove element using remove()
        vector.remove("Orange"); // Removes the first occurrence of "Orange" if present (it was replaced by Mango above, so let's remove Mango)
        vector.remove("Mango");
        System.out.println("Vector after removing 'Mango': " + vector);

        vector.remove(0); // Remove element at index 0
        System.out.println("Vector after removing element at index 0: " + vector);

        // Check size and capacity
        System.out.println("Size of vector: " + vector.size());
        System.out.println("Capacity of vector: " + vector.capacity());

        // Iterate over elements
        System.out.println("Iterating over vector:");
        for (String fruit : vector) {
            System.out.println(fruit);
        }
    }
}
