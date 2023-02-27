package com.fsk;

/**
 * LeetCode -> 2529. Maximum Count of Positive Integer and Negative Integer
 */

public class Main50 {

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
    }

    public static int maximumCount(int[] nums) {
        int countNegative = 0;
        int countPozitive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                countNegative++;
            }else if (nums[i] > 0) {
                countPozitive++;
            }
        }

        return Math.max(countPozitive, countNegative);
    }
}
