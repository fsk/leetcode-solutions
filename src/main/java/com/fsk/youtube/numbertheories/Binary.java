package com.fsk.youtube.numbertheories;

import java.util.BitSet;

public class Binary {
    public static void main(String[] args) {
        System.out.println(getBinary1(17));
        System.out.println(getBinary2(17));
        System.out.println(getBinary3(17));
        System.out.println(getBinary4(17));
    }

    public static String getBinary1(int number) {
        return Integer.toBinaryString(number);
    }

    public static String getBinary2(int number) {
        BitSet bitSet = BitSet.valueOf(new long[]{number});
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            stringBuilder.append(bitSet.get(i) ? '1' : '0');
        }

        return stringBuilder.toString();
    }

    public static String getBinary3(int number) {
        if (number == 0) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            stringBuilder.append(number % 2);
            number = number / 2;
        }
        return stringBuilder.reverse().toString();
    }

    public static String getBinary4(int number) {
        if (number < 2) return String.valueOf(number % 2);
        return getBinary4(number / 2) + number % 2;
    }
}