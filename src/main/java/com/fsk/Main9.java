package com.fsk;


import java.util.Arrays;

// Easy -> 35. Search Insert Position
public class Main9 {

    public static void main(String[] args) {
        int arr[] = new int[]{3,7,2,1,4,9,6};
        Arrays.sort(arr);
        for (int item : arr) {
            System.out.println(item);
        }

        System.out.println(Arrays.binarySearch(arr, 9));
    }

//    public static int searchInsert(int[] nums, int target) {
//
//        Arrays.sort(nums);
//
//        if (Arrays.binarySearch(nums, target))
//
//        return 0;
//
//    }
}
