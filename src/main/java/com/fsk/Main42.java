package com.fsk;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * LeetCode -> 169. Majority Element
 */
public class Main42 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }

    public static int majorityElement(int[] nums) {

        Map<Integer, Long> numList = Arrays
                .stream(nums)
                .boxed()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );

        int maxKey = Math.
                toIntExact(
                        Collections.max(
                                numList.entrySet(), (entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1
                        ).getKey());

        if (nums.length == 1) {
            return nums[0];
        }else if (nums.length == 0) {
            return -1;
        }else {
            return numList.get(maxKey) > nums.length / 2 ? maxKey : -1;
        }



    }

}
