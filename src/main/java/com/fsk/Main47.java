package com.fsk;

import java.util.Arrays;

/**
 * LeetCode -> 977. Squares of a Sorted Array
 */

public class Main47 {

    public static void main(String[] args) {
        int arr[] = {-4, -1, 0, 3, 10};
        System.out.println(sortedSquares3(arr));
    }

    /**
     * 5MS
     * Beats 50.33%
     * 44.4 MB
     */
    public static int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] * nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }


    /**
     * 10 MS
     * Beats 14.26%
     * Memory 44.4 MB
     *
     */
    public static int[] sortedSquaresWithStream(int[] nums) {
        return Arrays
                .stream(nums)
                .map(item -> item * item)
                .sorted()
                .toArray();
    }


    /**
     * 1 MS
     * Beats 100%
     * Memory 44.4 MB
     *
     */
    public static int[] sortedSquares3(int[] nums) {

        int[] array = new int[nums.length];

        int i = 0;

        int j = nums.length-1;
        int k = nums.length-1;

        while(i<=j){

            int val1 = nums[i] * nums[i];
            int val2 = nums[j] * nums[j];

            if(val1 > val2){
                array[k] = val1;
                i++;
            }else{
                array[k] = val2;
                j--;
            }
            k--;
        }

        return array;
    }

}
