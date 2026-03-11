package com.fsk.quest.arrays;

// LeetCode -> Quest1. Concatenation of Array

public class Main1 {
    public static void main(String[] args) {

    }

    public int[] getConcatenation(int[] nums) {
        int lengthArray = nums.length;
        int[] result = new int[lengthArray * 2];
        for (int i = 0; i < lengthArray; i++) {
            result[i] = nums[i];
            result[i + lengthArray] = nums[i];
        }
        return result;
    }
}
