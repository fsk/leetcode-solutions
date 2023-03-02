package com.fsk;


/**
 * LeetCode -> 1342. Number of Steps to Reduce a Number to Zero
 */

public class Main59 {

    public static void main(String[] args) {

        System.out.println(numberOfSteps(8));

    }

    public static int numberOfSteps(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
                count++;
            }else {
                num = num - 1;
                count++;
            }
        }

        return count;

    }

}
