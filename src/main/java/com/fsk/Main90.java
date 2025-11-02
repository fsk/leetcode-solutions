package com.fsk;

public class Main90 {

    public static void main(String[] args) {

        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1, 1, 0,1,1,1}));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;

    }
}
