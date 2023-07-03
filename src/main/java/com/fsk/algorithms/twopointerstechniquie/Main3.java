package com.fsk.algorithms.twopointerstechniquie;

public class Main3 {

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public static void moveZeroes(int[] nums) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) k++;
        }
        rotate(nums,0,nums.length-1);
        rotate(nums,0,k-1);
        rotate(nums,k,nums.length-1);

        for (Integer item : nums) {
            System.out.println(item);
        }

    }

    private static void rotate(int[] nums, int low, int high){

        while(low<high){

            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;

        }

    }
}
