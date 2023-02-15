package com.fsk;

/**
 * LeetCode -> 1281. Subtract the Product and Sum of Digits of an Integer
 */

public class Main34 {

    public static void main(String[] args) {

        System.out.println(subtractProductAndSum(4421));

    }

    public static int subtractProductAndSum(int n) {

        int totalCount = 0;
        int totalMultiply = 1;
        String num = n + "";
        for (int i = 0; i < num.length(); i++) {
            totalCount = totalCount + Character.getNumericValue(num.charAt(i));
            totalMultiply = totalMultiply * Character.getNumericValue(num.charAt(i));
        }

        return totalMultiply - totalCount;

    }
}
