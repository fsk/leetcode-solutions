package com.fsk.leetcodesolutions;

import java.util.HashSet;
import java.util.Set;

public class Main112 {


    // leetcode -> 2367
    public static int arithmeticTriplets(int[] nums, int diff) {

        int count = 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + diff * 2)) {
                count++;
            }
        }
        return count;
    }
}
