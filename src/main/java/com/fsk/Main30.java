package com.fsk;


import java.util.Arrays;


/**
 * LeetCode -> 2535. Difference Between Element Sum and Digit Sum of an Array
 */

public class Main30 {

    public static void main(String[] args) {

        System.out.println(differenceOfSum(new int[]{1,15,6,3}));

    }

    public static int differenceOfSum(int[] nums) {
        int sum = Arrays
                .stream(nums)
                .boxed()
                .mapToInt(Integer::intValue)
                .sum();

        int digitsSum = findDigitsSum(nums);

        return Math.abs(digitsSum - sum);
    }

    private static int findDigitsSum(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length ; i++) {
            String num = Integer.toString(nums[i]);
            for (int j = 0; j < num.length(); j++) {
                count = count + Character.getNumericValue(num.charAt(j));
            }
        }
        return count;
    }
}
