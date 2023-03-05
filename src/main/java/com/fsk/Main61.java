package com.fsk;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * LeetCode -> 1748. Sum of Unique Elements
 */

public class Main61 {

    public static void main(String[] args) {

        System.out.println(sumOfUnique2(new int[]{1,2,3,2}));

    }

    //8MS - 5.28% - 40.8 MB
    public static int sumOfUnique(int[] nums) {
        Map<Integer, Long> numsMap;
        numsMap = Arrays
                    .stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        int count = 0;
        for (Map.Entry<Integer, Long> item : numsMap.entrySet()) {
            if (item.getValue() == 1) {
                count = (count + item.getKey());
            }
        }

        return count;
    }


    //10 MS - Beats 5.28% - Memory 40.8 MS
    public static int sumOfUnique2(int[] nums) {
        Map<Integer, Long> numsMap;
        numsMap = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        return numsMap
                .entrySet()
                .stream()
                .filter(item -> item.getValue().intValue() == 1)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
