package com.fsk;

import java.math.BigInteger;


/**
 * LeetCode -> 67. Add Binary
 */

public class Main12 {

    public static void main(String[] args) {


        /**
         * addBinary methoduna String deger olarak
         * a ve b degerleri verilirse
         * NumberFormatException hatasi firlatir.
         */
        String a = "1010";
        String b = "11011";

        System.out.println(addBinary(a, b));

        toBinary(13);

    }

    public static String addBinary(String a, String b) {

        return new BigInteger(a, 2)
                .add(new BigInteger(b, 2))
                .toString(2);

    }


    //Oylesine yazilmis method.
    public static StringBuilder toBinary(int a) {
        StringBuilder instance = new StringBuilder();

        while (a > 0) {
            instance.append(a % 2);
            a = a / 2;
        }

        return instance.reverse();
    }
}
