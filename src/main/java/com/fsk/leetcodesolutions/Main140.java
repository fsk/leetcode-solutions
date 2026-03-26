package com.fsk.leetcodesolutions;

// LeetCode -> 168. Excel Sheet Column Title

public class Main140 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ABC"));
    }

    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int result = 0;
        int last = chars.length - 1;
        for (int i = last; i >= 0; i--) {
            int charResult = chars[i] - 'A' + 1;
            int res = charResult * (int) Math.pow(26, last - i);
            result = result + res;
        }
        return result;
    }

    public static int titleToNumber2(String columnTitle) {
        int result = 0;

        for (char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }

        return result;
    }
}
