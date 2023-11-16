package com.fsk;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * LeetCode -> 1394. Find Lucky Integer in an Array
 */

public class Main54 {

    public static void main(String[] args) {

        System.out.println(findLucky(new int[]{2, 2, 3,3,3, 4,4,4,4}));
    }

    public static int findLucky(int[] arr) {
        Map<Integer, Long> luckyMap;

        luckyMap = Arrays
                    .stream(arr)
                    .boxed()
                    .collect(
                            Collectors
                            .groupingBy(Function.identity(), Collectors.counting())
                    );

        if (luckyMap.entrySet()
                .stream()
                .noneMatch(item -> item.getKey() == item.getValue().intValue())
           )
            return -1;

        return Math.toIntExact(luckyMap.entrySet()
                .stream()
                .filter(item -> item.getKey() == item.getValue().intValue())
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue());

    }
}
