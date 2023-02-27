package com.fsk;


import java.util.ArrayList;
import java.util.List;
/**
 * LeetCode -> 2553. Separate the Digits in an Array
 */

public class Main51 {

    public static void main(String[] args) {
        int[] arr = separateDigits(new int[]{13,25,83,77});

        for (Integer item : arr) {
            System.out.println(item);
        }
    }


    public static int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < String.valueOf(nums[i]).split("\\B").length; j++) {
                list.add(Integer.valueOf(String.valueOf(nums[i]).split("\\B")[j]));
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();

    }

}
