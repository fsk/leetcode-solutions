package com.fsk;

/**
 * LeetCode -> 1071. Greatest Common Divisor of Strings
 */
public class Main46 {

    public static void main(String[] args) {

        String a = "ABABAB";
        String b = "ABA";
        String[] split = a.split(b);
        for(String item : split) {
            System.out.println(item.length());
        }

    }

}
