package com.fsk.leetcodesolutions;

import java.util.HashMap;
import java.util.Map;

public class Main118 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    map.put(substring, substring.length());
                }
            }
        }
        int max = 0;
        String result = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public static boolean isPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length()-1;
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }

}
