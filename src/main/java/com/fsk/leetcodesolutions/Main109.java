package com.fsk.leetcodesolutions;

import java.util.Collections;
import java.util.List;



// LeetCode 28
public class Main109 {

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        List<Character> h = haystack.chars().mapToObj(c -> (char) c).toList();
        List<Character> n = needle.chars().mapToObj(c -> (char) c).toList();
        return Collections.indexOfSubList(h, n);
    }

    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }



}
