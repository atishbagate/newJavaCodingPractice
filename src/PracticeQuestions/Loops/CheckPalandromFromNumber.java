package PracticeQuestions.Loops;

//2. Check if a Number is a Palindrome
//The Task: Determine if a number reads the same backward as forward (e.g., 121 is a palindrome, 123 is not).

//How the Loop Works:
//Store the original number, run the reverse loop logic from Question 1, and check if original == reversed.

public class CheckPalandromFromNumber {
    public static boolean checkPalandrom(int x) {
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        while (x > 0) {
            int digit = x % 10; // taking last digit
            reversed = (reversed * 10) + digit; // adding to new number
            x /= 10; // removing the digit from original number
        }
        return original == reversed;
    }

    public static void main(String[] args) {

        System.out.println(checkPalandrom(121));
    }
}
