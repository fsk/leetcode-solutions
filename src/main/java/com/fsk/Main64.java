package com.fsk;

/**
 * 29. Divide Two Integers
 */
public class Main64 {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        if (divisor == 1) return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long positiveDividend = Math.abs((long)dividend);
        long positiveDivisor = Math.abs((long)divisor);

        int count = 0;
        while (positiveDividend >= positiveDivisor) {
            positiveDividend = positiveDividend - positiveDivisor;
            count++;
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) return -count;

        return count;

    }


}
