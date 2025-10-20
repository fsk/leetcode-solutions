package com.fsk;

public class Main74 {

    public static void main(String[] args) {

        System.out.println(addStrings("176", "400"));
    }

    public static String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int len1 = num1.length();
        int len2 = num2.length();

        int max = Math.max(len1, len2);

        if (max == len1) {
            num2 = "0".repeat(len1 - len2) + num2;
        }else {
            num1 = "0".repeat(len2 - len1) + num1;
        }


        char[] num1CharArray = num1.toCharArray();
        char[] num2CharArray = num2.toCharArray();

        int carry = 0;
        for (int i = max -1 ; i >= 0; i--) {
            int numericValue1 = Character.getNumericValue(num1CharArray[i]);
            int numericValue2 = Character.getNumericValue(num2CharArray[i]);
            if ((numericValue1 + numericValue2) > 9) {
                if (carry == 1) {
                    sb.append((numericValue1 + numericValue2 + 1) % 10);
                    if ((numericValue1 + numericValue2 + 1) > 9) {
                        carry = 1;
                    }else  {
                        carry = 0;
                    }
                }else {
                    sb.append((numericValue1 + numericValue2) % 10);
                    carry = 1;
                }
            }else  {
                sb.append(numericValue1 + numericValue2 + carry);
                carry = 0;
            }
        }

        return sb.reverse().toString();
    }

    public static String addStrings2(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = (i >= 0) ? (num1.charAt(i) - '0') : 0;
            int d2 = (j >= 0) ? (num2.charAt(j) - '0') : 0;

            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        return sb.reverse().toString();

    }
}
