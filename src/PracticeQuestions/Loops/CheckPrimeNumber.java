package PracticeQuestions.Loops;

public class CheckPrimeNumber {

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        // check divisors upto square root of n
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(11));
        System.out.println(isPrime(15));
    }
}
