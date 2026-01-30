package com.fsk.leetcodesolutions;

public class Main103 {

    public static void main(String[] args) {
        System.out.println(multiply("10", "10"));
    }

    public static String multiply(String num1, String num2) {
        int carry = 0;
        int remainder;
        StringBuilder result = new StringBuilder();

        int height1 = num1.length();
        int height2 = num2.length();

        while (height1 > 0) {
            for (int j = height2; j > 0 ; j--) {
                String value1 = num1.substring(height1-1, height1);
                String value2 = num2.substring(j - 1, j);
                int res = Integer.parseInt(value2) * Integer.parseInt(value1);
                if (res > 10) {
                    remainder = res % 10;
                    carry = res - (remainder * 10);
                    result.append(remainder);
                }else {
                    res = res + carry;
                    if (res > 10) {
                        remainder = res % 10;
                        carry = res - (remainder * 10);
                        result.append(remainder);
                    }else {
                        result.append(res);
                    }

                }
                height1--;
            }
        }

        return result.reverse().toString();

    }

}
