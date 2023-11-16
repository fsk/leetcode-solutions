package com.fsk.interviews;

public class ArmstrongNumber {

    public static void main(String[] args) {
        System.out.println(isArmstrong(0));
    }
    public static boolean isArmstrong(int n) {
        String number = n+"";
        int length = number.length();
        int result = 0;

        for (int i = 0; i<length; i++) {
            result = result + (pow((number.charAt(i) - '0'), length));
        }
        return result == n;

    }
    public static int pow(int a, int b) {
        if (a == 1 || b == 0) return 1;
        else if (b == 1) return a;
        else return a * pow(a, b-1);
    }

}
