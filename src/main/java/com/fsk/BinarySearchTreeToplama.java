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
}
