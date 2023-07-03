package com.fsk.algorithms.binarysearchtree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode -> 35. Search Insert Position
 */

public class Main2 {

    public static void main(String[] args) {

        int arr[] = {1,3,5,6};

        //System.out.println(searchInsert(arr, 7));

        System.out.println(searchInsertWithBinarySearch(arr, 7));

    }

    /**
     * 3 MS
     * 5.12% Beats
     * 43 MB
     */
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


    /**
     * 6 MS
     * 5.12 % Beats
     * 42.4 MB
     */
    public static int searchInsertWithBinarySearch(int[] nums, int target) {

        int index = bst(nums, target);

        if (index == -1) {
            List<Integer> integerList = Arrays
                    .stream(nums)
                    .boxed()
                    .collect(Collectors.toList());

            integerList.add(target);

            return bst(integerList.stream().mapToInt(Integer::intValue).sorted().toArray(), target);
        }

        return index;

    }


    public static int bst(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;

        int index = -1;

        while (low <= high) {
            int middle = low + ((high - low) / 2);
            if (nums[middle] == target) {
                index = middle;
                break;
            }else if (nums[middle] < target) {
                low = middle + 1;
            }else if (nums[middle] > target) {
                high = middle -1;
            }
        }

        return index;
    }
}
