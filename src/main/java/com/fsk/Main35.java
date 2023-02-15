package com.fsk;

/**
 * LeetCode -> 1952. Three Divisors
 */

public class Main35 {
    public static void main(String[] args) {
        System.out.println(isThree(4));
    }

    public static boolean isThree(int n) {
        int count = 2;
        for (int i = 2; i < n ; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count == 3;
    }
}
