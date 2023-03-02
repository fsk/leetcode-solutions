package com.fsk;

/**
 * LeetCode -> 2469. Count Good Triplets
 */

public class Main56 {

    public static void main(String[] args) {

        double[] temperature = convertTemperature(36.50);
        for (double item : temperature) {
            System.out.println(item);
        }

    }

    public static double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, (celsius * 1.80) + 32.00};
    }

}
