package com.fsk;

import java.util.Arrays;

public class Main6 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Furkan Sahin Kulaksiz"));
    }

    public static int lengthOfLastWord(String s) {

        String newString = s.trim();
        String[] arr = newString.split(" ");
        return Arrays.asList(arr).get(arr.length - 1).length();

    }
}
