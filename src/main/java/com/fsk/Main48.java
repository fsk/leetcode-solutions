package com.fsk;

/**
 * LeetCode -> 2544. Alternating Digit Sum
 */

public class Main48 {

    public static void main(String[] args) {

        System.out.println(alternateDigitSum(886996));

    }

    public static int alternateDigitSum(int n) {
        int[] digits = Integer.toString(n).chars().map(c -> c - '0').toArray();
        int countPozitive = 0;
        int countNegative = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                countPozitive = countPozitive + digits[i];
            }else {
                countNegative = countNegative + digits[i];
            }
        }

        return countPozitive - countNegative;
    }

}
