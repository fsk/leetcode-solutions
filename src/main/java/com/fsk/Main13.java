package com.fsk;


/**
 * 231. Power of Two
 */

public class Main13 {

    public static void main(String[] args) {

        //System.out.println(isPowerOfTwo(15));

        isPowerOfTwo(1);


    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);

    }

}
