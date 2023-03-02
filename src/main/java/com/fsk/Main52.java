package com.fsk;

/**
 * LeetCode -> 50. Pow(x, n)
 */
public class Main52 {

    public static void main(String[] args) {
        //System.out.println(myPow(2,-2));

        //System.out.println(1D / 81D);

        //System.out.println(Math.pow(-10, 4));
        System.out.println(Math.pow(2, 10));
    }

    public static double myPow(double x, int n) {

        if (x < -100 && x > 100) {
            return 0.0;
        }

        double pozitivePow = Math.abs(n);
        double result = 1;
        for (int i = 1; i <= pozitivePow ; i++) {
            result = x * result;
        }

        if (result <= 10000.0) {
            return 0.0;
        }


        return n < 0 ? (1D / result) : result;
    }
}
