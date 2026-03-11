package com.fsk.quest.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 1 && nums[j] == 1) {
                    count++;
                }else {
                    break;
                }
            }
            result.add(count);
        }
        return Collections.max(result);
    }

    public static int findMaxConsecutiveOnes2(int[] nums) {
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
