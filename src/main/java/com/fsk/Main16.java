package com.fsk;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode -> 263. Ugly Number
 */

public class Main16 {
    public static void main(String[] args) {
        System.out.println(isUgly(14));
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

            if (!moreFiveList.isEmpty()) {
                return false;
            }else return true;

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
        if (count == 1) {
            return true;
        }else return false;
    }


    /**
     * LeetCode solution. This isnt my solution
     */
    public static boolean isUglyLeetCodeSolution(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 == 0) return isUglyLeetCodeSolution(n / 2);
        if (n % 3 == 0) return isUglyLeetCodeSolution(n / 3);
        if (n % 5 == 0) return isUglyLeetCodeSolution(n / 5);

        return false;
    }
}
