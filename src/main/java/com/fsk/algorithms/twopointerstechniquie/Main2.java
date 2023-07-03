package com.fsk.algorithms.twopointerstechniquie;

/**
 * LeetCode -> 189. Rotate Array
 */

public class Main2 {

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;
        rotate(nums,0,nums.length-1);
        rotate(nums,0,k-1);
        rotate(nums,k,nums.length-1);
    }

    private static void rotate(int[] nums, int low, int high){

        while(low<high){

            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;

        }

    }
}
