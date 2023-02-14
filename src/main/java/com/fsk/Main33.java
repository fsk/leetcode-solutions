package com.fsk;

/**
 * LeetCode -> 2520. Count the Digits That Divide a Number
 */

public class Main33 {

    public static void main(String[] args) {
        System.out.println(countDigits(1248));
    }

    public static int countDigits(int num) {
        int count = 0;
        String s = num+"";
        for (int i = 0; i < s.length(); i++) {
            if (num % Character.getNumericValue(s.charAt(i)) == 0) count++;
        }
        return count;
    }
}
