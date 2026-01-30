
package com.fsk.youtube.numbertheories;

public class PerfectNumber {

    public static void main(String[] args) {

        System.out.println(isPerfectNumber(10));

    }

    public static boolean isPerfectNumber(int number) {

        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        return sum == number;
    }

    public static boolean isPerfectNumber2(int number) {
        if (number < 2) return false;
        int sum = 1;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    public static boolean isPerfectNumber3(int number) {
        if (number < 2) return false;
        int sum = 1;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                int pair = number / i;
                if (pair != i) sum += pair;
            }
        }

        return sum == number;
    }
}
