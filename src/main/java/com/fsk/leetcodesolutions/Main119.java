package com.fsk.leetcodesolutions;

// LeetCode -> 28. Find the Index of the First Occurrence in a String

public class Main119 {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "xy"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.startsWith(needle, i)) return i;
        }
        return -1;
    }

}
