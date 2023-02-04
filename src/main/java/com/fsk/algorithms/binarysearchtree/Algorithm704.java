package com.fsk.algorithms.binarysearchtree;

import java.util.Arrays;

public class Algorithm704 {

    public static void main(String[] args) {

        int[] arr = {1,4,2,3,5,6,7};
        Arrays.sort(arr);
        System.out.println(search(arr, 3));

    }

    public static int search(int nums[], int target) {
        return Arrays.binarySearch(nums, target);
    }
}
