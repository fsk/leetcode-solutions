package com.fsk;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode -> 217. Contains Duplicate
 */

public class Main41 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{2,14,18,22,22}));
        System.out.println(containsDuplicate2(new int[]{2,14,18,22,22}));

    }

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;

    }


    public static boolean containsDuplicate2(int[] nums) {
        if (nums.length == 1) return false;
        Set<Integer> items = new HashSet<>();
        for (int num : nums) {
            if (!items.add(num)) {
                return true;
            }
        }
        return false;
    }


    public static boolean containsDuplicate3(int[] nums) {
        return IntStream
                .of(nums)
                .boxed()
                .collect(Collectors.toSet())
                .size() != nums.length;
    }
}
