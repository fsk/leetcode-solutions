package com.fsk.leetcodesolutions;

public class Main99 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5};
        duplicateZeros(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 0) {
                    int temp = arr[j];
                    arr[j] = 0;
                    arr[j++] = temp;
                }
            }
        }
    }
}
