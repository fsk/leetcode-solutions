package com.fsk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * LeetCode -> 268. Missing Number
 */

public class Main18 {

    public static void main(String[] args) {

        //System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber2(new int[]{0,1}));


    }

    public static int missingNumber(int[] nums) {

        int length = nums.length;

        Supplier<IntStream> numsStream = () -> IntStream.of(nums);

        int maxNumber = numsStream.get().max().getAsInt();

        if (length == maxNumber) {
            List<Integer> numList = numsStream
                    .get()
                    .sorted()
                    .boxed()
                    .toList();

            List<Integer> rangeArr = new ArrayList<>(IntStream.rangeClosed(0, maxNumber).boxed().toList());

            rangeArr.removeAll(numList);

            return rangeArr.get(0);
        }else return nums.length;

    }


    public static int missingNumber2(int[] nums) {
        int numsLength = nums.length;
        int shouldBeSum = (numsLength * (numsLength + 1)) / 2;
        int existSum = IntStream.of(nums).sum();
        return shouldBeSum - existSum;

    }

}
