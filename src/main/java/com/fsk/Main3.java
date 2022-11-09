package com.fsk;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> values = new LinkedHashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 == s.length() || values.get(s.charAt(i)) >= values.get(s.charAt(i + 1))) {
                number += values.get(s.charAt(i));
            } else {
                number -= values.get(s.charAt(i));
            }
        }
        return number;
    }
}
