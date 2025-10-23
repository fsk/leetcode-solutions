package com.fsk;

public class BinarySearchTreeToplama {

    public static void main(String[] args) {

        System.out.println(sum(1453,-1452));

    }

    public static int sum(int a, int b) {

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        while (min < max) {

            int mid = (min + max)  / 2;
            if (mid == a + b) { return mid; }
            else if (mid <  a + b) min = mid + 1;
            else max = mid - 1;

        }

        return min;
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

    public static boolean isPerfectSquare2(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (mid * mid == num) return true;
            else if (mid * mid > num) {
                end = mid - 1;
            }else if (mid * mid < num) {
                start = mid + 1;
            }
        }
        return false;
    }
}
