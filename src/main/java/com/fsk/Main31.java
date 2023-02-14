package com.fsk;

/**
 * LeetCode -> 2427. Number of Common Factors
 */

public class Main31 {

    public static void main(String[] args) {
        System.out.println(commonFactors(25 ,30));
    }

    public static int commonFactors(int a, int b) {
        int count = 0;
        int min = Math.min(a, b);
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
}
