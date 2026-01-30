package com.fsk.leetcodesolutions;

import java.util.Arrays;

public class Main91 {

    public static void main(String[] args) {
    }

    public static int findNumbers(int[] nums) {

        return Math.toIntExact(Arrays
                .stream(nums)
                .mapToObj(String::valueOf)
                .toList()
                .stream()
                .filter(s -> s.length() % 2 == 0)
                .count());

    }

    public static int findNumbers2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int digit = 0;
            while (nums[i] > 0) {
                nums[i] = nums[i] / 10;
                digit++;
            }
            if (digit % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
