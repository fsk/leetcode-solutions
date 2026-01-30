package com.fsk.interviews.adobe;

public class Question3 {

    public static void main(String[] args) {

    }


    public static int missingNumber(int[] nums) {

        int expectedSum = ((nums.length) *  (nums.length + 1)) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum = actualSum + num;
        }
        return expectedSum - actualSum;
    }




}
