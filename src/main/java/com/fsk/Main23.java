package com.fsk;

/**
 * LeetCode -> 367. Valid Perfect Square
 */

public class Main23 {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare2(120));
    }


    //Linear Search
    public static boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0 && num / i == i) {
                return true;
            }
        }
        return false;
    }

    //BinarySearch MySolution
    public static boolean isPerfectSquare2(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (mid * mid == num) return true;
            else if (mid * mid > num) {
                end = mid - 1;
            }else if (mid * mid < num) {
                start = mid + 1;
            }
        }
        return false;
    }


    //BinarySearch LeetCodeSolution
    public static boolean isPerfectSquare3(int num) {
        long start = 1;
        long end = num;
        while(start <= end){
            long mid = (start + end)/2;
            if(mid * mid == num){
                return true;
            }
            else if(mid * mid > num){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return false;
    }

}
