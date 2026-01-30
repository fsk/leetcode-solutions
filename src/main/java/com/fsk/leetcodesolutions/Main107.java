package com.fsk.leetcodesolutions;


import java.util.Arrays;

// LeetCode 26
public class Main107 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int writer = 1;
        for (int reader = 1; reader < nums.length; reader++) {
            if (nums[reader] != nums[writer - 1]) {
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
    }

}
