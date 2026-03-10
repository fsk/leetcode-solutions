package com.fsk.leetcodesolutions;

public class Main121 {

    // LeetCode -> 3794. Reverse String Prefix

    public static void main(String[] args) {

        System.out.println(reversePrefix("abcd", 2));
        System.out.println(reversePrefix2("abcd", 2));
    }

    public static String reversePrefix(String s, int k) {
        if (k <= 1) return s;
        String str = s.substring(0, k);
        String str2 = s.substring(k);
        String reverseStr = new StringBuilder(str).reverse().toString();
        return reverseStr + str2;
    }

    public static String reversePrefix2(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = k - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }


}
