package com.fsk.leetcodesolutions;

// LeetCode -> 1133. Largest Unique Number

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main125 {

    public static void main(String[] args) {

        int[] nums = {5,7,3,9,4,9,8,3,1};
        System.out.println(largestUniqueNumber(nums));

    }

    public static int largestUniqueNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        //return Collections.max(map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).toList());
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .max(Integer::compareTo)
                .orElse(-1);
    }

    public static int largestUniqueNumber2(int[] nums) {
        int[] count = new int[2000];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 1) {
                return i;
            }
        }
        return -1;
    }

}
