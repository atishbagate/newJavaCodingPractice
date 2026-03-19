package PracticeQuestions;

import java.util.Set;

public class VowelCounter {
//    The Task: Count how many vowels (a, e, i, o, u) are in a given sentence.
//    The Logic: Convert the string to lowercase first so you don't have to check for 'A' and 'a' separately, then loop through each character.

    public static void main(String[] args) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        String input = "I love programming";
        int count = 0;
        String inputStr = input.toLowerCase();

//        for (int i = 0; i < inputStr.length(); i++) {
//            char ch = inputStr.charAt(i);
//            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
//                count++;
//            }
//        }
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);

            if (vowels.contains(ch)) {
                count++;
            }
        }
        System.out.println("vowel count : " + count);
    }
}
