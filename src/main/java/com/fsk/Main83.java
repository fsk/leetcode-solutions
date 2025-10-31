package com.fsk;

public class Main83 {

    public static void main(String[] args) {

        System.out.println(myPow(2, 5));
    }

    public static double myPow(double x, int n) {
        boolean flag = true;
        if (n < 0) {
            n = -n;
            flag = false;
        }

        double result = 1;

        while (n > 0) {
            if ((n % 2) == 1) {
                result = result * x;
            }
            x =  x * x;
            n = n / 2;
        }

        if (flag) {
            return result;
        }else {
            return 1 / result;
        }
    }
}
