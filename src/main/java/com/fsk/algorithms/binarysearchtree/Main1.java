package com.fsk.algorithms.binarysearchtree;

import java.util.stream.IntStream;

/**
 * LeetCode -> 278. First Bad Version
 */

public class Main1 {

    public static void main(String[] args) {

        System.out.println(firstBadVersion(6));

    }

    public static int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        while(low <= high){
            int mid = low + ((high - low) / 2);

            if(isBadVersion(mid) == false){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return low;
    }


    private static boolean isBadVersion(int n) {
        return true;
    }

}
