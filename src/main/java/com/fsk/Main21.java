package com.fsk;

/**
 * LeetCode -> 507. Perfect Number
 */

public class Main21 {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }

    public static boolean checkPerfectNumber(int num) {

        if (num <= 0 || num % 2 != 0) {
            return false;
        }

        int count = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                count = count + i;
            }
        }

        return num == count;
    }
}

