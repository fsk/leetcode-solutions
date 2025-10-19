package com.fsk.youtube.twopointertechnique.codings.q2;

public class Main {

    public static void main(String[] args) {
        System.out.println(twoPointerTechnique2FindPalindrome("kazak"));
    }


    public static boolean twoPointerTechnique2FindPalindrome(String str) {

        int leftPointer = 0;
        int rightPointer = str.length() - 1;

        while (leftPointer < rightPointer) {
            if (str.charAt(leftPointer) != str.charAt(rightPointer)) return false;
            leftPointer++;
            rightPointer--;
        }

        return true;
    }
}
