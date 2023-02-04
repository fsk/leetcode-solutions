package com.fsk;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * LeetCode -> 88. Merge Sorted Array
 */
public class Main10 {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {3,4,5};

        merge(nums1, nums2);

    }

    public static void merge(int[] nums1, int[] nums2) {

        Arrays.stream(IntStream
                .concat(IntStream.of(nums1), IntStream.of(nums2))
                .sorted()
                .toArray())
                .forEach(System.out::println);


    }

}
