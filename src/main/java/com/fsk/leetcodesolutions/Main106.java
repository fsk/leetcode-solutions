package com.fsk.leetcodesolutions;

import java.util.HashMap;
import java.util.Map;

public class Main106 {

    public static void main(String[] args) {
        String s = "abccaa";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {

        char[] charArray = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : charArray) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }else {
                map.put(c, map.get(c) + 1);
            }
        }

        return map.values()
                .stream()
                .filter(v -> v % 2 == 1)
                .count() <= 2;
    }
}
