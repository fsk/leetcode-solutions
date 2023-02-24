package com.fsk;

/**
 * LeetCode -> 2485. Find the Pivot Integer
 */

public class Main45 {

    public static void main(String[] args) {
        System.out.println(pivotInteger(49));
    }

    public static int pivotInteger(int n) {

        int start = 1;
        int end = n;

        while (start <= end) {

            int pivot = (start + end) / 2;

            int sum1= (pivot) * (pivot + 1) / 2;
            int sum2=(n * (n+1) ) / 2 - sum1 + pivot;

            if (sum1 == sum2) {
                return pivot;
            }else if (sum1 < sum2) {
                start = pivot + 1;
            }else end = pivot - 1;
        }

        return -1;
    }
}
