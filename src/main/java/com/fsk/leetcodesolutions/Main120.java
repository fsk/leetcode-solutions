package com.fsk.leetcodesolutions;

// LeetCode -> 3491. Phone Number Prefix

public class Main120 {

    public static void main(String[] args) {

    }

    public static boolean phonePrefix(String[] numbers) {
        for (String str : numbers) {
            for (int j = 0; j < str.length(); j++) {
                String str2 = str.substring(j);
                if (str.startsWith(str2)) return true;
            }
        }
        return false;
    }
}
