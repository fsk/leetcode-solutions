package com.fsk.quest.arrays;

// LeetCode -> Quest2. Shuffle the Array

public class Main2 {

    public static void main(String[] args) {
        int[] shuffle = shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
        for (int item : shuffle) {
            System.out.println(item);
        }
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] resultArray = new int[2 * n];

        int i = 0;
        int j = n;
        int k = 0;
        while (i < n ) {
            resultArray[k] = nums[i];
            resultArray[k + 1] = nums[j];
            i++;
            j++;
            k = k + 2;
        }
        return resultArray;
    }

    public static int[] shuffle2(int[] nums, int n) {
        int[] resultArray = new int[2 * n];
        for (int i = 0; i < n; i++) {
            resultArray[2 * i] = nums[i];
            resultArray[2 * i + 1] = nums[i + n];
        }
        return resultArray;
    }
}
