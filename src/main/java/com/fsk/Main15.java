package com.fsk;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * LeetCode -> 258. Add Digits
 */

public class Main15 {

    public static void main(String[] args) {

        System.out.println(addDigits2(456));


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
}
