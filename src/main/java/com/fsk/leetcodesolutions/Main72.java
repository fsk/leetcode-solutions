package com.fsk.leetcodesolutions;


import java.util.Map;

/**
 * 246. Strobogrammatic Number
 */

public class Main72 {

    public static void main(String[] args) {

    }

    public static boolean isStrobogrammatic(String num) {

        Map<Character, Character> map = Map.of(
                '0', '0',
                '1', '1',
                '6', '9',
                '8', '8',
                '9', '6'
        );

        int leftIndex = 0;
        int rightIndex = num.length() - 1;

        while (leftIndex <= rightIndex) {
            char leftChar = num.charAt(leftIndex);
            char rightChar = num.charAt(rightIndex);

            if (!map.containsKey(leftChar)) return false;
            if (map.get(leftChar) != rightChar) return false;
            leftIndex++;
            rightIndex--;
        }

        return true;

    }
}
