package com.fsk.problems1;

public class Main1 {

    /**
     *
     * 1480. Running Sum of 1d Array
     */

    public static void main(String[] args) {

    }

    public static int[] runningSum(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length ; i++) {
            total = total + nums[i];
            nums[i] = total;
        }
        return nums;

    }
}
