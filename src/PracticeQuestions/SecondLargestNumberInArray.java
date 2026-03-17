package PracticeQuestions;
//The Goal: Find the second-highest number in an array in one single pass.

//The Swap: Think of it like a race. If a new runner takes 1st place, the person who was in 1st place naturally moves down to 2nd place.
//
//Handling Duplicates: The condition current != largest is very important. If the array is [50, 50, 45], without this check, both largest and secondLargest would become 50. This check ensures we get the actual different second-largest value.

public class SecondLargestNumberInArray {

    public static void main(String[] args) {
        int[] number = {10, 20, 35, 50, 50, 45};
        int largest = -1;
        int secondLarges = -1;

        for (int i = 0; i < number.length; i++) {
            int current = number[i];
            if (current > largest) {
                secondLarges = largest;
                largest = current;
            } else if (current > secondLarges && current != largest) {
                secondLarges = current;
            }
        }
        System.out.println("second largest number : " + secondLarges);
    }
}
