package com.fsk.denemeler;

public class Main6 {

    public static void main(String[] args) {

    }

    public static int sumStrings(String num1 , String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = (i >= 0) ? (num1.charAt(i) - '0') : 0;
            int d2 = (j >= 0) ? (num2.charAt(j) - '0') : 0;
            int sum = d1 + d2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return Integer.parseInt(result.reverse().toString());
    }
}
