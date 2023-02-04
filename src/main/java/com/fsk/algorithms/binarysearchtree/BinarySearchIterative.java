package com.fsk.algorithms.binarysearchtree;

import java.util.Arrays;

public class BinarySearchIterative {

    public static void main(String[] args) {

        System.out.println(searchIterative(new int[]{3,4,5,6,10,12}, 10));

    }

    public static int searchIterative(int nums[], int target) {

        int index = -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                index = mid;
                break;
            }
        }
        return index;


    }
}
