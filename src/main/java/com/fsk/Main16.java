package com.fsk;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode -> 263. Ugly Number
 */

public class Main16 {
    public static void main(String[] args) {
        System.out.println(isUgly3(10));
    }

    public static boolean isUgly(int n) {

        if (n == 1) {
            return true;
        }else if (n <= 0) {
            return false;
        }

        List<Integer> isUglyList = primeFactorList(n);

        if (isUglyList.size() > 3) {
            return false;
        }else {
            List<Integer> moreFiveList = isUglyList
                    .stream()
                    .sorted()
                    .filter(item -> item > 5)
                    .toList();

            return moreFiveList.isEmpty();

        }
    }

    public static List<Integer> primeFactorList(int n) {
        List<Integer> primeFactorList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && isPrime(i)) {
                primeFactorList.add(i);
            }
        }
        return primeFactorList;
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count == 1;
    }


    /**
     * LeetCode solution. This isnt my solution
     */
    public static boolean isUgly2(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 == 0) return isUgly2(n / 2);
        if (n % 3 == 0) return isUgly2(n / 3);
        if (n % 5 == 0) return isUgly2(n / 5);

        return false;
    }

    public static boolean isUgly3(int n) {
        int[] divisors = {2, 3, 5};
        for (int divisor : divisors) {
            while (n % divisor == 0) {
                n = n / divisor;
            }
        }

        // Eğer sonunda sayı 1'e eşitse, bu bir ugly sayıdır.
        return n == 1;
    }
}
