package com.fsk.leetcodesolutions;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode -> 258. Add Digits
 */

public class Main15 {

    public static void main(String[] args) {

        //System.out.println(addDigits2(456));
        System.out.println(addDigits3(456));


    }

    public static int  addDigits(int num) {
        String intToString = String.valueOf(num);

        List<Integer> listInt = Arrays.stream(intToString
                        .split("\\B"))
                .map(Integer::valueOf).toList();

        int total = listInt.stream().mapToInt(item -> item).sum();

        if (listInt.size() > 1) {
            return addDigits(total);
        }else return total;

    }

    public static int addDigits2(int num) {
        return num==0 ? 0 : num%9==0 ? 9 : num%9;
    }

    public static int addDigits3(int num) {
        int i = sumDigit(num);
        while (i > 9) {
         i = sumDigit(i);
        }
        return i;
    }

    private static int sumDigit(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum = sum + digit;
            num = num / 10;
        }
        return sum;
    }
}
