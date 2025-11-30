package com.fsk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main98 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3, 4}));

    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permuteList = new ArrayList<>();
        backtracking(nums, 0, permuteList);
        return permuteList;
    }

    public static void backtracking(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtracking(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
