package com.fsk.leetcodesolutions;

import java.util.stream.IntStream;

/**
 * LeetCode -> 2652. Sum Multiples
 */

public class Main113 {

    public static void main(String[] args) {

    }

    public static int sumOfMultiples(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                .sum();
    }

    public static int sumOfMultiples2(int n) {
        return sum(n,3) + sum(n,5) + sum(n,7) - sum(n,15) - sum(n,21) - sum(n,35) + sum(n,105);
    }

    private static int sum(int n, int k) {
        int c = n / k;
        return k * c * (c + 1) / 2;
    }
}
