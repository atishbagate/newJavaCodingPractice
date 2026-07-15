package Exception_Handling.one_hirarcy_of_exception_and_types.Exception_Theory;

public class Finally {
    public static void main(String[] args) {
        try {
            int a = 100, b = 0, c;
            c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");
        } finally {
            System.out.println("finally");
        }
    }
}

//1. The Trick Question: "Does finally always execute?"
//How it's asked: "Is there any scenario where the finally block will absolutely NOT execute?"
// The Answer: Yes, there are a few specific scenarios where finally is bypassed:
// System.exit(0): If System.exit() is called inside the try or catch block, the JVM terminates immediately, preventing the finally block from running.
// JVM Crash / System Power Failure: If the underlying system crashes, runs out of OS memory, or loses power, the process dies instantly.
// Infinite Loop / Thread Death: If the try block gets stuck in an infinite loop or the executing thread is forcefully killed (Thread.stop()), the finally block won't be reached.

//2. The Return Value Conflict
//How it's asked: "What does this method return if both the try block and the finally block have a return statement?"

//public int testMethod() {
//    try {
//        return 10;
//    } catch (Exception e) {
//        return 20;
//    } finally {
//        return 30;
//    }
//}
//The Answer: The method will return 30.
//The Logic: If a finally block contains a return statement, it overrides/swallows any previous return statement or exception thrown in the try or catch blocks.
//Interview Tip: Warn the interviewer that putting a return statement in a finally block is considered bad practice because it suppresses exceptions and makes code hard to debug.

//3. Modifying Variables in finally
//How it's asked: "What is the output of the following code? Does changing the value in finally affect the returned value?"
//public int calculate() {
//    int value = 5;
//    try {
//        return value; // returns 5
//    } finally {
//        value = 10;
//        System.out.println("Finally block executed");
//    }
//}
//The Answer: The method returns 5, but the variable value inside the finally block does become 10.
//The Logic: When the return value; statement is hit in the try block, Java copies the value (5) to a temporary return slot on the stack. Then, the finally block executes and changes the local variable value to 10. Once finally finishes, the JVM returns the value that was previously saved on the stack (5).

//6. The Modern Alternative: Try-with-Resources
//How it's asked: "If we use finally primarily to close resources (like BufferedReader or Connection), what is the better way to do this in modern Java?"
//The Answer: Try-with-resources (introduced in Java 7).
//The Logic: Any class that implements the AutoCloseable interface can be declared inside the try(...) parentheses. Java automatically closes these resources at the end of the statement, eliminating the need for a boilerplate finally block. It also handles the "swallowed exception" problem automatically using suppressed exceptions.

//difference between final finally & finalize
//How it's asked: "Can you explain the difference between final, finally, and finalize?"

//The Answer: This is a classic definition checklist question:
//
// final: A keyword used to apply restrictions. A final class cannot be inherited, a final method cannot be overridden, and a final variable cannot be changed (constant).
// finally: A block used with try-catch to execute important clean-up code (like closing files or database connections) regardless of whether an exception is thrown or not.
// finalize(): A protected method in the Object class that the Garbage Collector used to call just before destroying an object. (Note: It has been deprecated since Java 9 and should not be used).
