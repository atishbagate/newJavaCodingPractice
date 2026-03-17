package PracticeQuestions;

import java.util.HashMap;


//Question
//1. Find the First Non-Repeated Character
//The Goal: Find the first character that appears only once in a string.

//The Explanation
//First Loop: We use a HashMap to store how many times each character appears. We go through the string from start to finish.
//
//Second Loop: We go through the string again in the same order. For each character, we check our Map. The first one we find with a count of 1 is our answer.
//
//Why two loops? The first loop "learns" the counts; the second loop ensures we respect the "first" in the string.

public class FindFirstNonRepeatingCharater {
    public static void main(String[] args) {
        // your code goes here
        String input = "swiss";

        // Step 1: Count the frequency of each character
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        // Step 2: Find the first character with a count of 1
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (charCountMap.get(c) == 1) {
                System.out.println("First non-repeated character: " + c);
                return; // Exit as soon as we find the first one
            }
        }
    }
}
