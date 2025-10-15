package com.fsk.ankarabilimuni;

public class Mainnnn {


    public static void main(String[] args) {

        System.out.println(isPrime(218312345));
    }


    public static boolean isPrime(int num) {

        if (num <= 1 ) return false; // 0 and 1 is not a prime numbers.
        if (num == 2) return true; // 2 is smallest prime number.
        if (num % 2 == 0) return false; // even numbers are not prime numbers.

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;

    }


}
