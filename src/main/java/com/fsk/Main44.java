package com.fsk;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode -> 43. Multiply Strings
 */

public class Main44 {

    public static void main(String[] args) {

    }

    public static String multiply(String num1, String num2) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < num1.length(); i++) {
            numList.add(Character.getNumericValue(num1.charAt(i)));
        }
    }
}
