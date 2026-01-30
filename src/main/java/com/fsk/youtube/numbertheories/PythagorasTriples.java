package com.fsk.youtube.numbertheories;

import java.util.HashSet;
import java.util.Set;

public class PythagorasTriples {

    public static void main(String[] args) {

        System.out.println(pythagorasTriples());
    }

    public static Set<Integer> pythagorasTriples() {

        int total = 1000;
        Set<Integer> result = new HashSet<>();

        for (int a = 1; a <= total; a++) {
            for (int b = 1; b <= total; b++) {
                for (int c = 1; c <= total; c++) {
                    if (((a * a) + (b * b) == (c * c)) && ((a < c) && (b < c) && ((a + b + c) == total))) {
                        result.add(a);
                        result.add(b);
                        result.add(c);
                    }
                }
            }
        }

        return result;

    }

    public static void pythagorasTriples2() {
        int total = 1000;

        for (int m = 2; m < 1000; m++) {
            for (int n = 1; n < m; n++) {
                int a = m * m - n * n;
                int b = 2 * m * n;
                int c = m * m + n * n;

                if (a + b + c == total) {
                    System.out.printf("a=%d, b=%d, c=%d%n", a, b, c);
                    return;
                }
            }
        }
    }


    public static void pythagorasTripleByDivision() {

        int total = 1000;

        for (int a = 1; a < total; a++) {
            int numerator = 2000 * a - total * total;
            int denominator = 2 * a - 2000;


            if (numerator % denominator == 0) {
                int b = numerator / denominator;
                int c = total - a - b;

                if (b > 0 && c > 0 && a * a + b * b == c * c) {
                    System.out.printf("a=%d, b=%d, c=%d%n", a, b, c);
                    return;
                }
            }
        }


    }

}
