package com.fsk.problems1;

import java.util.Arrays;

/**
 * 724. Find Pivot Index
 */
public class Main2 {

    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum = totalSum + num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length ; i++) {
            int rightSum = totalSum - nums[i] - leftSum;
            if (rightSum == leftSum) {
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
