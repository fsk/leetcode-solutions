package com.fsk;

import java.util.Arrays;

/**
 * LeetCode -> 242. Valid Anagram
 */

public class Main37 {

    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccac"));
    }

    //Stream Sorting
//    public static boolean isAnagram(String s, String t) {
//        List<Character> sCharList = new ArrayList<>(s.chars().mapToObj(item -> (char) item).sorted().toList());
//        List<Character> tCharList = new ArrayList<>(t.chars().mapToObj(item -> (char) item).sorted().toList());
//
//        return sCharList.equals(tCharList);
//
//    }


    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        return Arrays.equals(sCharArr, tCharArr);

    }
}
