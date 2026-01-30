package com.fsk.leetcodesolutions;

import java.util.Arrays;

public class Main92 {

    public static void main(String[] args) {


    }

    public static int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;

    }

    public static int[] sortedSquares2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }

    public static int[] sortedSquares3(int[] nums) {


        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int[] result = new int[nums.length];
        int pos = nums.length - 1;

        while (leftPointer <= rightPointer) {
            int leftSquare = nums[leftPointer] * nums[leftPointer];
            int rightSquare = nums[rightPointer] * nums[rightPointer];

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                leftPointer++;
            } else {
                result[pos] = rightSquare;
                rightPointer--;
            }
            pos--;
        }
        return result;
    }
}
