package com.fsk;

/**
 * LeetCode -> 2413. Smallest Even Multiple
 */

public class Main28 {

    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(6));
    }

    public static int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
