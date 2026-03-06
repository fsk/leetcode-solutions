package com.fsk.leetcodesolutions;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main117 {
    public static void main(String[] args) {
        //System.out.println(numberCount(10, 13));
        System.out.println(numberCount2(10, 13));
    }

    // LeetCode -> 3032. Count Numbers With Unique Digits II
    public static int numberCount(int a, int b) {
        AtomicInteger count = new AtomicInteger();
        IntStream.rangeClosed(a, b).forEach(number -> {
            String s = String.valueOf(number);
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i; j < s.length() ; j++) {
                    if (s.charAt(i) != s.charAt(j) ) {
                        count.incrementAndGet();
                    }
                }
            }
        });
        return count.get();
    }

    public static int numberCount2(int a, int b) {
        int count = 0;
        for (int i = a; i <= b ; i++) {
//            if (uniqueDigitsCount(i)) count++;
//            if (uniqueDigitsCount2(i)) count++;
            if (uniqueDigitsCount3(i)) count++;
        }
        return count;
    }

    private static boolean uniqueDigitsCount3(int i) {
        boolean[] digits = new boolean[10];
        while (i > 0) {
            int digit = i % 10;
            if (digits[digit]) {
                return false;
            }
            digits[digit] = true;
            i = i / 10;
        }
        return true;
    }

    private static boolean uniqueDigitsCount(int i) {
        Set<Integer> set = new HashSet<>();
        while (i > 0) {
            int digit = i % 10;
            if (set.contains(digit)) {
                return false;
            }
            set.add(digit);
            i = i / 10;
        }
        return true;
    }

    private static boolean uniqueDigitsCount2(int i) {
        return IntStream.rangeClosed(1, i).noneMatch(j -> String.valueOf(i).contains(String.valueOf(j)));
    }
}
