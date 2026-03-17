package PracticeQuestions;
//The Goal: Reverse a string without the reverse() method, but using StringBuilder for memory efficiency.


//StringBuilder: As a senior developer, you should mention that using a regular String in a loop is slow because Strings are immutable (they can't be changed, so Java creates a new one every time). StringBuilder is mutable and faster.
//        The Loop: We set our index i to length - 1 (the last letter) and use i-- to walk backwards until we hit 0.

public class ReverseAString {
    public static void main(String[] args) {

        String str = "Pune City";
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        System.out.println("Reversed String : " + sb.toString());
    }
}
