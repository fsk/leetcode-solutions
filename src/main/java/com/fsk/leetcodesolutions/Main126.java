package com.fsk.leetcodesolutions;

// LeetCode -> 392. Is Subsequence

public class Main126 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abck", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int tMin = 0;
            int tMax = t.length() - 1;
            char targetChar = s.charAt(i);
            while (tMin < tMax) {
                if (t.charAt(tMin) == targetChar || t.charAt(tMax) == targetChar) {
                    count++;
                    break;
                }
                tMax--;
                tMin++;
            }
        }
        return count == s.length();
    }

    public static boolean isSubsequence2(String s, String t) {
        // s in icerisinde t var mi ona bakacaz
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
