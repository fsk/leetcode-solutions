package com.fsk.leetcodesolutions;

public class Main139 {

    public static void main(String[] args) {
        System.out.println(reverseDegree("abc"));
    }

    public static int reverseDegree(String s) {
        String reverseString = new StringBuilder(s).reverse().toString();

        int j = 1;
        int sum = 0;

        for (int i = 0; i < reverseString.length(); i++) {
            char c = reverseString.charAt(i);
            int value = c - 'a' + 1;

            sum += value * j;
            j++;
        }

        return sum;
    }
}
