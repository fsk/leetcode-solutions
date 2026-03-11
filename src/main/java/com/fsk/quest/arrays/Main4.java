package com.fsk.quest.arrays;


// LeetCode -> Quest1. Set Mismatch

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main4 {

    public static void main(String[] args) {
        System.out.println(findErrorNums(new int[]{1, 2, 2, 4}));
    }

    public static int[] findErrorNums(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int sumOriginal = n * (n + 1) / 2;

        int sumCurrent = 0;
        for (int num : nums) {
            sumCurrent += num;
        }

        int duplicate = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                duplicate = nums[i];
                break;
            }
        }

        int missing = duplicate + (sumOriginal - sumCurrent);

        return new int[]{duplicate, missing};
    }
}
