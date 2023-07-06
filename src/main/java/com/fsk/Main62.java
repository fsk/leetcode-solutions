package com.fsk;

/**
 * LeetCode -> 1768. Merge Strings Alternately
 */

public class Main62 {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "cde"));
        System.out.println(mergeAlternately("ankara", "furkan"));
        System.out.println(mergeAlternately("abcef", "de"));
        System.out.println(mergeAlternately("", "abc"));
        System.out.println(mergeAlternately("furkan", ""));


    }


    public static String mergeAlternately2(String word1, String word2) {

        char[] charArrayWord1 = word1.toCharArray();
        char[] charArrayWord2 = word2.toCharArray();

        StringBuilder sb = new StringBuilder();

        if (charArrayWord1.length >= charArrayWord2.length) {
            for (int i = 0; i < charArrayWord1.length; i++) {
                sb.append(charArrayWord1[i]);

                if (i < charArrayWord2.length) {
                    sb.append(charArrayWord2[i]);
                }

            }
        }else {
            for (int i = 0; i < charArrayWord2.length; i++) {

                if (i < charArrayWord1.length) {
                    sb.append(charArrayWord1[i]);
                }
                    sb.append(charArrayWord2[i]);

            }
        }
        return sb.toString();

    }


    public static String mergeAlternately(String word1, String word2) {

        char[] charArrayWord1 = word1.toCharArray();
        char[] charArrayWord2 = word2.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArrayWord1.length || i < charArrayWord2.length; i++) {

            if (i < charArrayWord1.length) {
                sb.append(charArrayWord1[i]);
            }

            if (i < charArrayWord2.length) {
                sb.append(charArrayWord2[i]);
            }
        }

        return sb.toString();

    }

}
