package com.fsk;

import java.util.Set;

/**
 * LeetCode 345. Reverse Vowels of a String
 */

public class Main71 {

    public static void main(String[] args) {

    }


    public static String reverseVowels(String s) {

        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        char[] charArray = s.toCharArray();

        while (leftPointer < rightPointer) {
            if (!vowelsSet.contains(charArray[leftPointer])) {
                leftPointer++;
                continue;
            }

            if (!vowelsSet.contains(charArray[rightPointer])) {
                rightPointer--;
                continue;
            }

            char temp = charArray[leftPointer];
            charArray[leftPointer] = charArray[rightPointer];
            charArray[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }

        return String.valueOf(charArray);
    }
}
