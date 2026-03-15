package com.fsk.leetcodesolutions;

/**
 * LeetCode -> 896. Monotonic Array
 */

public class Main129 {

    public static void main(String[] args) {

    }

    public static boolean isMonotonic(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (!(nums[i] <= nums[j])) {
                    return false;
                } else if ((nums[i] >= nums[j])) {
                    return false;
                }
            }
        }
        return true;
    }

}
