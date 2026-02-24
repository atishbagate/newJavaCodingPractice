package Collections.StackExample;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Create a Stack
        Stack<String> stack = new Stack<>();
        // Push elements onto the stack
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");
        System.out.println("Stack after pushes: " + stack);

        // Peek at the top element (without removing it)
        String topElement = stack.peek();
        System.out.println("Top element (peek): " + topElement);

        // Pop elements from the stack (removes the top element)
        String poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after pop: " + stack);

        // Check if the stack is empty
        boolean isEmpty = stack.empty();
        System.out.println("Is stack empty? " + isEmpty);

        // Search for an element (returns 1-based position from the top)
        int position = stack.search("Second");
        if (position != -1) {
            System.out.println("'Second' is at position: " + position + " from the top");
        } else {
            System.out.println("'Second' not found in stack");
        }
        // Iterate over the stack
        System.out.println("Iterating over stack:");
        for (String item : stack) {
            System.out.println(item);
        }
    }
}
