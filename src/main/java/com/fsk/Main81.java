package com.fsk;

public class Main81 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,4,7, 7, 9, 12, 12}));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
