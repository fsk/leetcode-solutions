package com.fsk.leetcodesolutions;

// LeetCode -> 3280. Convert Date to Binary

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main138 {

    public static void main(String[] args) {

    }

    public static String convertDateToBinary(String date) {
        String[] dateParts = date.split("-");
        StringBuilder result = new StringBuilder();
        for (String part : dateParts) {
            String binary = getBinary(Integer.parseInt(part));
            result.append(binary);
            result.append("-");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static String getBinary(int number) {
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            binary.append(number % 2);
            number = number / 2;
        }
        return binary.reverse().toString();
    }

    public String convertDateToBinary2(String date) {
        return Arrays.stream(date.split("-"))
                .map(s -> Integer.toBinaryString(Integer.parseInt(s)))
                .collect(Collectors.joining("-"));
    }
}
