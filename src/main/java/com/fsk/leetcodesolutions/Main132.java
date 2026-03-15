package com.fsk.leetcodesolutions;

import java.util.Set;

/**
 * LeetCode -> 1119. Remove Vowels from a String
 */

public class Main132 {
    public static void main(String[] args) {
        System.out.println(removeVowels("leetcodeisacommunityforcoders"));
    }

    public static String removeVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        return s.replaceAll("[aeiou]", "");
    }

    public static String removeVowels2(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                s = s.replace(String.valueOf(s.charAt(i)), "");
            }
        }
        return s;
    }

    public static String removeVowels3(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!vowels.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
