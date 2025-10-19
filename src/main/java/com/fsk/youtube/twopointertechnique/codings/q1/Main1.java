package com.fsk.youtube.twopointertechnique.codings.q1;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 8, 4, 13, 6, 1};
        int target = 12;

        method1(arr, target);
    }

    public static void method1(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }


    public static int[] twoPointerTechnique(int[] arr, int target) {

        Arrays.sort(arr);
        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        while (leftPointer < rightPointer) {
            int sum = arr[leftPointer] + arr[rightPointer];

            if (sum == target) {
                return new int[]{arr[leftPointer], arr[rightPointer]};
            } else if (sum < target) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return new int[]{};
    }
}
