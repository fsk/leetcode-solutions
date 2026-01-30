package com.fsk.denemeler;

import java.util.Arrays;

public class Main4 {

    public static void main(String[] args) {


        System.out.println(isAnagram("Sakarya", "aksaray"));


    }



    public static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) return false;

        char[] charA = a.toLowerCase().toCharArray();
        char[] charB = b.toLowerCase().toCharArray();

        Arrays.sort(charA);
        Arrays.sort(charB);

        return Arrays.equals(charA, charB);

    }
}
