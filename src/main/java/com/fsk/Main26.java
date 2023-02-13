package com.fsk;

import java.math.BigInteger;

/**
 * LeetCode -> 66. Plus One
 */

public class Main26 {

    public static void main(String[] args) {

        int[] arr = plusOne(new int[]{4, 3, 2, 1});

        for (int item : arr) {
            System.out.println(item);
        }

    }

    public static int[] plusOne(int[] digits) {

        StringBuilder num = new StringBuilder();

        for (int digit : digits) {
            num.append(digit);
        }

        BigInteger value = new BigInteger(num.toString());
        BigInteger value2 = BigInteger.valueOf(1);

        String result = value.add(value2).toString();

        int arr[] = new int[result.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Character.getNumericValue(result.charAt(i));
        }

        return arr;
    }

}
