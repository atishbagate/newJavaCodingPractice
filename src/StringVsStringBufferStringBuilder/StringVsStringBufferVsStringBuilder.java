package StringVsStringBufferStringBuilder;

public class StringVsStringBufferVsStringBuilder {

    public static void main(String[] args) {
        // --- String (Immutable) ---
        System.out.println("--- String (Immutable) ---");
        String str = "Hello";
        // When we "modify" a String, a new object is created.
        String newStr = str.concat(" World");
        System.out.println("Original String: " + str); // Prints "Hello"
        System.out.println("New String: " + newStr);   // Prints "Hello World"
        System.out.println();

        // --- StringBuffer (Mutable and Thread-Safe) ---
        System.out.println("--- StringBuffer (Mutable and Thread-Safe) ---");
        StringBuffer stringBuffer = new StringBuffer("Hello");
        // Modifying a StringBuffer changes the object itself.
        stringBuffer.append(" World");
        System.out.println("StringBuffer: " + stringBuffer); // Prints "Hello World"
        System.out.println();

        // --- StringBuilder (Mutable and Not Thread-Safe) ---
        System.out.println("--- StringBuilder (Mutable and Not Thread-Safe) ---");
        StringBuilder stringBuilder = new StringBuilder("Hello");
        // Modifying a StringBuilder also changes the object itself.
        stringBuilder.append(" World");
        System.out.println("StringBuilder: " + stringBuilder); // Prints "Hello World"
        System.out.println();

        // --- Performance Comparison ---
        System.out.println("--- Performance Comparison ---");
        int iterations = 100000;

        // String concatenation
        long startTime = System.currentTimeMillis();
        String testString = "";
        for (int i = 0; i < iterations; i++) {
            testString += "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ms");

        // StringBuffer concatenation
        startTime = System.currentTimeMillis();
        StringBuffer testStringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            testStringBuffer.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ms");

        // StringBuilder concatenation
        startTime = System.currentTimeMillis();
        StringBuilder testStringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            testStringBuilder.append("a");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ms");
    }
}
