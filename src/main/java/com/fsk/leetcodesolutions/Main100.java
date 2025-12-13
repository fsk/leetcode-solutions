package com.fsk.leetcodesolutions;

// LeetCode -> 14 Long Prefix

public class Main100 {

    public static void main(String[] args) {



    }

    public static String longestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;

    }

}
