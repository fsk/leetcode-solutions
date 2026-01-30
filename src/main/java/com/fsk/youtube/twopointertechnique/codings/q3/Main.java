package com.fsk.youtube.twopointertechnique.codings.q3;

public class Main {


    public static void main(String[] args) {

        System.out.println(containerWithMostWater(new int[]{1, 8, 6, 2, 5, 8, 3, 7}));
    }


    public static int containerWithMostWater(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;

    }
}
