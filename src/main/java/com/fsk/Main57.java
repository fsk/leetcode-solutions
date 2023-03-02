package com.fsk;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode -> 1. Two Sum
 */

public class Main57 {

    public static void main(String[] args) {
        int[] res = twoSum2(new int[]{3,2,3}, 6);
        for (int item : res) {
            System.out.println(item);
        }

//        int[] res = new int[]{3,4,7,8,5,2,1,6,4,2,1};
//        Arrays.sort(res);
//        System.out.println(Arrays.binarySearch(res, 0));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }


    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {

            int param = containsSum(nums, target - nums[i]);
            if (i != param) {
                return new int[]{i, param};
            }
        }
        return new int[]{};
    }

    private static int containsSum(int[] nums, int i) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        if (list.contains(i)) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i && i != j) return j;
            }
        }
        return 0;
    }


}
