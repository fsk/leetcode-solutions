package com.fsk;

import java.util.Arrays;

/**
 * LeetCode -> 1913. Maximum Product Difference Between Two Pairs
 */

public class Main44 {

    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{4,2,5,9,7,4,8}));
    }


    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }

}
