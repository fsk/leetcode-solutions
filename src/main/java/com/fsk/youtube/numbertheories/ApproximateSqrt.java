package com.fsk.youtube.numbertheories;

public class ApproximateSqrt {

    public static void main(String[] args) {

        System.out.println(approximateValue(3));

    }

    public static double approximateValue(int number) {

        int i = 1;
        double x = 1.0;
        while (i < 10) {
            x = 0.5 * (x + number / x);
            i++;
        }

        return x;
    }

    public static boolean isPerfectSquareNewton(int n) {
        if (n < 0) return false;
        long x = n;
        while (x * x > n) {
            x = (x + n / x) / 2;
        }
        return x * x == n;
    }

    public static boolean isPerfectSquareByDifferences(int n) {
        if (n < 0) return false;
        int odd = 1;
        while (n > 0) {
            n = n - odd;
            odd = odd + 2;
        }
        return n == 0; // sıfırda biterse tam karedir
    }
}
