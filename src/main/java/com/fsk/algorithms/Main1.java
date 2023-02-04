package com.fsk.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 35. Search Insert Position
 */

public class Main1 {

    public static void main(String[] args) {

        int arr[] = {1,3,5,6};

        System.out.println(searchInsert(arr, 7));

    }

    public static int searchInsert(int[] nums, int target) {

        List<Integer> numList = IntStream
                .of(nums)
                .boxed()
                .collect(Collectors.toList());


        if (!numList.contains(target)) {
            numList.add(target);
            Collections.sort(numList);
        }

        return numList.indexOf(target);
    }
}
