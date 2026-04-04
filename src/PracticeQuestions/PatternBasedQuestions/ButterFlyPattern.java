package PracticeQuestions.PatternBasedQuestions;

public class ButterFlyPattern {
    public static void main(String[] args) {
        ButterFlyPattern obj = new ButterFlyPattern();
        obj.ButterFly(5);
    }

    public void ButterFly(int n) {
        // Upper half
        for (int i = 1; i <= n; i++) {
            // 1st part: Left Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // 2nd part: Middle Spaces
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // 3rd part: Right Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int i = n; i >= 1; i--) {
            // 1st part: Left Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            // 2nd part: Middle Spaces
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // 3rd part: Right Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
