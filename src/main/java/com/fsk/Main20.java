package com.fsk;

/**
 * LeetCode -> 342. Power of Four
 */

public class Main20 {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }

    public static boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 4 == 0) {
            n = n / 4;
        }

        return n == 1;
    }
}
