package PracticeQuestions.PatternBasedQuestions;

public class FloydsTrangle {
    public static void main(String[] args) {
        FloydsTrangle obj = new FloydsTrangle();
        obj.printPattern(5);
    }

    public void printPattern(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
