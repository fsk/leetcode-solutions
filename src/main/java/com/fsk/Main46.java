package com.fsk;

public class Main46 {

    public static void main(String[] args) {
        //System.out.println(addStrings("9333852702227987", "85731737104263"));

        System.out.println(convertToInt("9333852702227987"));
    }

    public static String addStrings(String num1, String num2) {

        long intNum1 = convertToInt(num1);
        long intNum2 = convertToInt(num2);

        return intNum1 + intNum2 + "";
    }

    public static long convertToInt(String s) {

        long sum = 0;

        for (int i = s.length() - 1; i >= 0 ; i--) {
            sum = (long) (sum + (Character.getNumericValue(s.charAt(i)) * Math.pow(10, (s.length() - 1 - i))));
        }

        return sum;
    }
}
