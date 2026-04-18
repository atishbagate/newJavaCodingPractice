package PracticeQuestions.ArrayExample;
//Problem Statement: Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
//Example 1:
//Input: nums = [3, 0, 1]
//Output: 2
//Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
//Example 2:
//Input: nums = [0, 1]
//Output: 2
//Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
//Example 3:
//Input: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
//Output: 8

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5};
         int missednumber = findMissingNumber(arr);
         System.out.println(missednumber);
    }
    public static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int sum = (n + 1) * (n + 2) / 2;
        for (int num : arr) {
            sum -= num;
        }
        return sum;
    }
}
