package com.fsk;


/**
 * 125. Valid Palindrome
 */

public class Main11 {


    public static void main(String[] args) {


        String s = "furkan";
        System.out.println(s.replaceAll(" ", ""));

        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {


        String newString = s
                .toLowerCase()
                .replaceAll("[^a-z0-9]", "");

        String reverseString = new StringBuilder(newString)
                .reverse()
                .toString();

        return newString.equals(reverseString);

    }

    public static boolean isPalindrome2(String s) {


        String str= s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reverseString=new StringBuffer(str).reverse().toString();
        return str.equals(reverseString);

    }
}
