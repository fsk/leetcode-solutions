package com.fsk;

/**
 * LeetCode -> 557. Reverse Words in a String III
 */
public class Main43 {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder newString = new StringBuilder();
        for (String word : words) {
            newString.append(" ").append(reverseWord(word));
        }
        return newString.deleteCharAt(0).toString();
    }

    public static String reverseWord(String s) {
        StringBuilder reverseString = new StringBuilder(s);
        return reverseString.reverse().toString();
    }
}
