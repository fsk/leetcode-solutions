package com.fsk.algorithms.binarysearchtree;

public class BinarySearchRecursive {

    public static void main(String[] args) {

        int arr[] = new int[]{3,4,5,6,10,12};

        System.out.println(searchRecursive(arr, 10, 0, arr.length - 1));

    }

    public static int searchRecursive(int nums[], int target, int lowIndex, int highIndex) {

        int middle = lowIndex + ((highIndex - lowIndex) / 2);

        if (highIndex < lowIndex) {
            return -1;
        }

        if (target == nums[middle]) {
            return middle;
        }else if (target < nums[middle]) {
            return searchRecursive(nums, target, lowIndex, middle - 1);
        }else return searchRecursive(nums, target, middle + 1, highIndex);

    }
}
