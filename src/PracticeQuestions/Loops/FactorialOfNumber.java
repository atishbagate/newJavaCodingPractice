package PracticeQuestions.Loops;
//3. Find the Factorial of a Number

//How the Loop Works:
//Start with an accumulator initialized to 1, then multiply it by each integer from 1 up to n in a for loop.

public class FactorialOfNumber {

    public static int factorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return (int) factorial;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

}
