package PracticeQuestions;

//The Optimized Approach (Recommended for Interviews)The most efficient way to check for a prime number
// is to iterate only up to the square root of the number ($n$).Why? If $n$ is divisible by some number
// $p$, then $n = p \times q$. If both $p$ and $q$ were greater than $\sqrt{n}$, then $p \times
// q$ would be greater than $n$. Therefore, at least one factor must be less than or equal to $\sqrt{n}$.

//3. Key Interview Talking PointsTo truly ace the question, mention these three points after writing your
// code:Edge Cases: Always mention that $0$, $1$, and negative numbers are not prime.Time Complexity:
// Explicitly state that the square root approach runs in $O(\sqrt{n})$ time.Mathematical Shortcutting:
// Mention that by checking n % 2 == 0 and n % 3 == 0 first, you can skip many iterations in the loop (this is known as the $6k \pm 1$ optimization).

public class checkPrimeOrNot {
    public static void main(String[] args) {


    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        // 2. Optimization: Eliminate even numbers and multiples of 3
        int n = 0;
        if (n % 2 == 0 || n % 3 == 0) return false;

        // 3. Iterate up to √n
        // We use i * i <= n instead of Math.sqrt(n) for better performance
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
