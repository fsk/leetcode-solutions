package com.fsk.leetcodesolutions;

import java.util.stream.IntStream;

public class Main113 {

    public static void main(String[] args) {

    }

    // leetcode -> 2652. Sum Multiples

    public static int sumOfMultiples(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                .sum();
    }
}
