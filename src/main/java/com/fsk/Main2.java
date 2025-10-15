package com.fsk;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }

    public static boolean isPalindrome(int x) {
        int r, sum = 0, temp;

        temp = x;

        while (x > 0) {
            r=x%10;  //getting remainder
            sum=(sum*10)+r;
            x=x/10;
        }
        return temp == sum;
    }
}
