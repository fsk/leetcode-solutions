package com.fsk;

/**
 * LeetCode -> 7. Reverse Integer
 */

public class Main17 {

    public static void main(String[] args) {
        System.out.println(reverse(-350));
    }

    public static int reverse(int x) {

        try {
            if (x < 0) {
                String val = x + "";
                String withoutMinus = val.replace("-", "");
                StringBuilder value = new StringBuilder(withoutMinus);
                return -Integer.parseInt(value.reverse().toString());
            }else {
                StringBuilder value = new StringBuilder(String.valueOf(x));
                return Integer.parseInt(value.reverse().toString());
            }
        }catch (NumberFormatException ex) {
            return 0;
        }


    }

}
