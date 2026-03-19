package PracticeQuestions;

public class CheckPalindrome {
//    The Task: Check if a word reads the same forward and backward (e.g., "madam" or "racecar").
//    The Logic: Compare the original string with its reversed version. Pro-tip: Use .equals() to compare String content, not ==.

    public static void main(String[] args) {
        String str = "madam";
        String revStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            revStr = revStr + str.charAt(i);
        }


        System.out.println("palindrome is there : " + str.equals(revStr));

    }
}
