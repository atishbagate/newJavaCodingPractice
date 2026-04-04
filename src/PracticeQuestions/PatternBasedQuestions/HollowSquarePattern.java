package PracticeQuestions.PatternBasedQuestions;

public class HollowSquarePattern {
    public static void main(String[] args) {
        HollowSquarePattern obj = new HollowSquarePattern();
        obj.printPattern(5);
    }

    public void printPattern(int n) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || i == n || j == 0 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
