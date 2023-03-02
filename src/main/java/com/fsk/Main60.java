package com.fsk;

import java.util.*;

/**
 * LeetCode -> 2465. Number of Distinct Averages
 */

public class Main60 {

    public static void main(String[] args) {
        System.out.println(distinctAverages2(new int[]{4,1,4,0,3,5}));
    }

    //With Arraylist
    public static int distinctAverages(int[] nums) {

        List<Double> averageList = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i <= nums.length / 2 && j >= nums.length / 2 ; i++, j--) {
            averageList.add((nums[i] + nums[j]) / 2D);
        }

        return (int) averageList.stream().distinct().count();
    }


    //With Set
    public static int distinctAverages2(int[] nums) {

        Set<Double> averageList = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i <= nums.length / 2 && j >= nums.length / 2 ; i++, j--) {
            averageList.add((nums[i] + nums[j]) / 2D);
        }

        return averageList.size();
    }

}
