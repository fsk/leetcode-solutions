package com.fsk.youtube.numbertheories;

public class ArmstrongNumber {

    public static void main(String[] args) {

        System.out.println(isArmstrong(153));

    }

    public static boolean isArmstrong(int number) {

        int original = number;

        int digitsNumber = String.valueOf(number).length();
        double sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum = sum + Math.pow(digit, digitsNumber);
            number = number / 10;
        }

        return original == sum;
    }

}
