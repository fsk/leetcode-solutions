package com.fsk;

public class Main75 {

    public static void main(String[] args) {


    }


    public static int peakIndexInMountainArray(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }
}
