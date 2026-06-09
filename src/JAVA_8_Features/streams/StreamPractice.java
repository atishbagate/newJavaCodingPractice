package JAVA_8_Features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {
 // updated
    public static void main(String[] args) {
        System.out.println("--- Java 8 Stream API Practice ---");

        // 1. Find the highest/second-highest number
        List<Integer> numbers = Arrays.asList(10, 20, 35, 50, 50, 75, 65);
        findSecondHighest(numbers);

        // 2. Count the frequency of characters in a String
        String input = "javaprogramming";
        countCharacterFrequency(input);

        // 3. Find duplicate elements in a List
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6);
        findDuplicates(duplicateNumbers);
    }

    private static void findSecondHighest(List<Integer> numbers) {
        System.out.println("\n1. Second Highest Number in " + numbers);

        Integer secondHighest = numbers.stream()
                .distinct() // Remove duplicates like the two 50s
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(1) // Skip the first (highest) element
                .findFirst() // Get the second one
                .orElse(-1);

        System.out.println("Result: " + secondHighest);
    }

    private static void countCharacterFrequency(String input) {
        System.out.println("\n2. Character frequency in string: '" + input + "'");

        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Result: " + frequencyMap);
    }

    private static void findDuplicates(List<Integer> numbers) {
        System.out.println("\n3. Find duplicate elements in " + numbers);

        // Group by element and count occurrences, then filter those with count > 1
        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Result: " + duplicates);
    }
}
