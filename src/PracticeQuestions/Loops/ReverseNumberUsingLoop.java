package PracticeQuestions.Loops;

//1. Reverse a Number
//The Task: Take an integer (e.g., 1234) and return it reversed (4321).
//How the Loop Works:
//Extract the last digit with modulo: number % 10.
//Append it to the reversed value: reversed = (reversed * 10) + digit.
//Drop the last digit using integer division: number = number / 10.
//Stop the while loop when number == 0.

public class ReverseNumberUsingLoop {
    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            reversed = (reversed * 10) + lastDigit;
            x = x / 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println("output is - " + reverse(12345));
    }
}
