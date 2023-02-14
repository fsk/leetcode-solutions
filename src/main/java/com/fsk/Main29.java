package com.fsk;

import java.util.Arrays;

/**
 * LeetCode -> 1979. Find Greatest Common Divisor of Array
 */

public class Main29 {

    public static void main(String[] args) {
        System.out.println(findGCD(new int[]{7,5,6,8,3}));
    }

    public static int findGCD(int[] nums) {

        int ebob = 1;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];

        for (int i = 1; i <= min && i <= max; i++) {
            if (min % i == 0 && max % i == 0) ebob = i;
        }

        return ebob;
    }
}
