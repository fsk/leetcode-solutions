package com.fsk.leetcodesolutions;

// LeetCode -> 43. Multiply Strings

public class Main127 {

    public static void main(String[] args) {
        System.out.println(multiply("24", "7"));
    }

    public static String multiply(String num1, String num2) {

        int n = num1.length();
        int m = num2.length();

        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;

            }
        }
        return null;
    }

}
