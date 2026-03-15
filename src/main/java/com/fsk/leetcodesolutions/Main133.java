package com.fsk.leetcodesolutions;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode -> 1134. Armstrong Number
 */

public class Main133 {

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }

    public static boolean isArmstrong(int n) {
        int digitNumber = String.valueOf(n).length();
        int intDigit = n;
        int sum = 0;
        while (intDigit > 0) {
            int digit = intDigit % 10;
            sum = (int) (sum + Math.pow(digit, digitNumber));
            intDigit = intDigit / 10;
        }
        return sum == n;
    }

}
