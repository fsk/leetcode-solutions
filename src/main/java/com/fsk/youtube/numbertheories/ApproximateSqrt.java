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
}
