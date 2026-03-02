package com.fsk.leetcodesolutions;


// LeetCode 27
public class Main108 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3,2,2,3,2,3};
        System.out.println(removeElement(nums, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int writer = 0;
        for (int reader = 0; reader < nums.length; reader++) {
            if (nums[reader] != val) {
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
    }

}
