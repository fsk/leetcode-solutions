package com.fsk.leetcodesolutions;

public class Main116 {

    public static void main(String[] args) {
        //System.out.println(countSymmetricIntegers(1200, 1230));
        //System.out.println(countSymmetricIntegers2(1200, 1230));
    }

    // leetcode -> 2843

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = i + "";
            if (s.length() % 2 == 0) {
                int mid = s.length() / 2;
                int sum1 = 0;
                for (int j = 0; j < mid; j++) {
                    sum1 = sum1 + (s.charAt(j) - '0');
                }

                int sum2 = 0;
                for (int j = mid; j < s.length(); j++) {
                    sum2 = sum2 + (s.charAt(j) - '0');
                }
                if (sum1 == sum2) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countSymmetricIntegers2(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);

            if (s.length() % 2 != 0) continue;

            int left = 0;
            int right = s.length() - 1;
            int sum1 = 0;
            int sum2 = 0;

            while (left < right) {
                sum1 = sum1 + s.charAt(left) - '0';
                sum2 = sum2 + s.charAt(right) - '0';
                left++;
                right--;
            }

            if (sum1 == sum2) {
                count++;
            }
        }

        return count;
    }

    public static int countSymmetricIntegers3(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            int digits = (int) (Math.log10(num) + 1);
            if (digits % 2 != 0) continue;
            int half = digits / 2;
            int divisor = (int)(Math.pow(10, half));
            int leftPart = num / divisor;
            int rightPart = num % divisor;
            if (digitsSum(leftPart) == digitsSum(rightPart)) {
                count++;
            }
        }
        return count;
    }

    private static int digitsSum(int part) {
        int sum = 0;
        while (part > 0) {
            sum = sum + part % 10;
            part = part / 10;
        }
        return sum;
    }

}
