package com.fsk;

/**
 * LeetCode -> 326. Power of Three
 */

public class Main19 {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree2(-81));
    }

    public static boolean isPowerOfThree(int n) {

        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0) return isPowerOfThree(n / 3);
        else return false;

    }

    public static boolean isPowerOfThree2(int n) {

        if (n <= 0) {
            return false;
        }

        while (n >= 1) {
            if (n % 3 == 0) {
                n = n / 3;
            }else return n == 1;
        }
        return true;
    }
}
