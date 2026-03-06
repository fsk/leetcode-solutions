package com.fsk.leetcodesolutions;

public class Main115 {

    public static void main(String[] args) {
        System.out.println(largestEven("1"));
    }

    // leetcode -> 3798. Largest Even Number
    public static String largestEven(String s) {
        if (s.isEmpty()) return "";
        if (s.charAt(s.length() - 1) == '2') {
            return s;
        }else return largestEven(s.substring(0, s.length() - 1));
    }

    public static String largestEven2(String s) {
        int index = s.lastIndexOf('2');
        if (index == -1) return "";
        return s.substring(0, index + 1);
    }

}
