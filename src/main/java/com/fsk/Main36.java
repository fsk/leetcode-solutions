package com.fsk;

import java.util.*;


/**
 * LeetCode -> 405. Convert a Number to Hexadecimal
 */

public class Main36 {

    public static void main(String[] args) {

        System.out.println(toHex(-1));
        System.out.println(toHex(26));
        System.out.println(toHex(-234));
    }



    public static String toHex(int num) {
        StringBuilder hexadecimalForm = new StringBuilder();
        Map<Long, String> hex = new HashMap<>();
        hex.put(0L, "0");
        hex.put(1L, "1");
        hex.put(2L, "2");
        hex.put(3L, "3");
        hex.put(4L, "4");
        hex.put(5L, "5");
        hex.put(6L, "6");
        hex.put(7L, "7");
        hex.put(8L, "8");
        hex.put(9L, "9");
        hex.put(10L, "a");
        hex.put(11L, "b");
        hex.put(12L, "c");
        hex.put(13L, "d");
        hex.put(14L, "e");
        hex.put(15L, "f");

        if (num == 0) {
            return hex.get(0L);
        }

        long val = num;
        if (num < 0) {
            val = 4_294_967_296L + num; // 2 ^ 32
        }


        while (val >= 1) {
            long remainder = val % 16;
            hexadecimalForm.append(hex.get(remainder));
            val = val / 16;
        }
            return hexadecimalForm.reverse().toString();
    }
}


