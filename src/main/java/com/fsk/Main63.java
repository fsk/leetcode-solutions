package com.fsk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2733. Neither Minimum nor Maximum
 */
public class Main63 {

    public static void main(String[] args) {
        System.out.println(findNonMinOrMax(new int[]{2,3,4,5}));
    }

    public static int findNonMinOrMax(int[] nums) {

        if (nums.length <= 2) return -1;

        List<Integer> list = Arrays.stream(nums).boxed().toList();

        List<Integer> integerList = new ArrayList<>(list);

        Integer min = integerList.stream().mapToInt(Integer::intValue).min().getAsInt();
        Integer max = integerList.stream().mapToInt(Integer::intValue).max().getAsInt();

        integerList.remove(min);
        integerList.remove(max);

        return integerList.stream().findAny().orElse(-1);

    }


    public static int findNonMinOrMax2(int[] nums) {

        if (nums.length <= 2) return -1;

        Arrays.sort(nums);

        return nums[1];

    }


}
