package PracticeQuestions.PatternBasedQuestions;

public class NumberPyramid {

    public static void main(String[] args) {
        NumberPyramid obj = new NumberPyramid();
        obj.pyramid(5);
    }

    public void pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // 1. print leading space
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // 2. print descending number
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            // 3. print ascending number
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
