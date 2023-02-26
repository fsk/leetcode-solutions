package com.fsk;

import java.util.Arrays;

/**
 * LeetCode -> 977. Squares of a Sorted Array
 */

public class Main47 {

    public static void main(String[] args) {
        int arr[] = {-4, -1, 0, 3, 10};
        System.out.println(sortedSquares(arr));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] * nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }


    public static int[] sortedSquaresWithStream(int[] nums) {
        return Arrays.stream(nums).map(item -> item * item).sorted().toArray();
    }

}
