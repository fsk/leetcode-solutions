package com.fsk.leetcodesolutions;

// LeetCode -> 1085. Sum of Digits in the Minimum Number

import java.util.Arrays;

public class Main123 {
    public static void main(String[] args) {

    }

    public static int sumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int result = nums[0];
        int sum = 0;
        while (result > 0) {
            sum = sum + result % 10;
            result = result / 10;
        }
        if(sum % 2 == 0) {
            return 1;
        }else return 0;
    }
}
