package com.fsk;


public class Main5 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 4, 1, 3, 2, 4}));
    }

    public static int singleNumber(int[] nums) {

        if (nums.length >= 1 && nums.length <= (Math.pow(10, 4) * 3)) {


            outsideFor:
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i != j && nums[i] == nums[j]) {
                        continue outsideFor;
                    }
                }
                return nums[i];
            }

            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else return 0;
    }


}
