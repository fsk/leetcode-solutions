package com.fsk;

/**
 * LeetCode -> 2455. Average Value of Even Numbers That Are Divisible by Three
 */

public class Main27 {

    public static void main(String[] args) {
        System.out.println(averageValue(new int[]{1,2,4,7,10}));
    }

    public static int averageValue(int[] nums) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 6 == 0) {
                total = total + nums[i];
                count++;
            }
        }

        return count == 0 ? 0 : total / count;
    }

}
