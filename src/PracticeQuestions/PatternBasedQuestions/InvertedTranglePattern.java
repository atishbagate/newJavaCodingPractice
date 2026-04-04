package PracticeQuestions.PatternBasedQuestions;

public class InvertedTranglePattern {
    public static void main(String[] args) {
        System.out.println("Inverted trangle.");

        int rows = 5;
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Inverted trangle 2.");

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
