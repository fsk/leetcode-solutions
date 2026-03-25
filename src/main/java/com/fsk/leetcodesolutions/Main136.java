package com.fsk.leetcodesolutions;

// 2894. Divisible and Non-divisible Sums Difference


import java.util.stream.IntStream;

public class Main136 {
    public static void main(String[] args) {

    }

    public static int differenceOfSums(int n, int m) {

        int[] arr = IntStream.rangeClosed(1, n).toArray();
        int sum1 = 0;
        int sum2 = 0;
        for (int j : arr) {
            if (j % m == 0) {
                sum1 = sum1 + j;
            } else {
                sum2 = sum2 + j;
            }
        }
        return Math.abs(sum1 - sum2);

    }


    public static int differenceOfSums2(int n, int m) {

        int generalSum = (n * (n + 1)) / 2;
        int k = n / m;
        int num1 = (k * (k + 1) / 2) * m;
        int num2 =  generalSum - num1;
        return num1 - num2;

    }
}
