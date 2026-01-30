package com.fsk.interviews.adobe;

import java.util.*;

public class Question1 {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int sum = nums[leftIndex] + nums[rightIndex];
            if (sum == target) {
                list.add(leftIndex);
                list.add(rightIndex);
                break;
            }else if (sum > target) {
                rightIndex--;
            }else  {
                leftIndex++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new  int[0];

    }

}
