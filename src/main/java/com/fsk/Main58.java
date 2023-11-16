package com.fsk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;


/**
 * LeetCode -> 349. Intersection of Two Arrays
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 * Kesişimlerinden bir dizi dönecek.
 */

public class Main58 {

    public static void main(String[] args) {
        int[] arr = intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});

        for (Integer item : arr) {
            System.out.println(item);
        }
    }

    //Stream
    // 14MS
    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> intersectionList = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    intersectionList.add(nums1[i]);
                }
            }
        }

        return intersectionList
                .stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    //Set
    // 6MS
    public static int[] intersection2(int[] nums1, int[] nums2) {
        var nums1Set = Arrays
                .stream(nums1)
                .boxed()
                .collect(Collectors.toSet());

        var nums2Set = Arrays
                .stream(nums2)
                .boxed()
                .collect(Collectors.toSet());

        var intersectionSet = new HashSet<Integer>();

        for (Integer item : nums1Set) {
            if (nums2Set.contains(item)) {
                intersectionSet.add(item);
            }
        }

        return intersectionSet
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();


    }
}
