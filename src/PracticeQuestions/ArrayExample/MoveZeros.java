package PracticeQuestions.ArrayExample;
//Problem Statement: Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//Note: You must do this in-place without making a copy of the array.
//Example 1:
//Input: nums = [0, 1, 0, 3, 12]
//Output: [1, 3, 12, 0, 0]
//Example 2:
//Input: nums = [0]
//Output: [0]
//Example 3:
//Input: nums = [4, 2, 4, 0, 0, 3, 0, 5, 1, 0]
//Output: [4, 2, 4, 3, 5, 1, 0, 0, 0, 0]

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] arr = {1,0,4,0,0,9,7,9};
        MoveZeros obj = new MoveZeros();
        obj.moveZerosApproach1(arr);
        System.out.println("output arr "+ Arrays.toString(arr));
    }

    public void moveZerosApproach1(int[] arr) {


        int insertPosition = 0;  // Tracks where the next non-zero should go

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[insertPosition] = arr[i];
                insertPosition++;
            }
        }
        // fill rest arrays with 0
       while(insertPosition < arr.length){
           arr[insertPosition] = 0;
           insertPosition++;
       }
    }
}

