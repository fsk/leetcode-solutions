package com.fsk.youtube.twopointertechnique.codings.q4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15, 3, 6, 8, 1, 7, 2, 8 , 1};
        System.out.println(twoSum(arr, 9));

    }

    public static Set<Set<Integer>> twoSum(int[] arr , int target) {

        Arrays.sort(arr);
        int startIndex = 0;
        int endIndex = arr.length - 1;

        Set<Set<Integer>> listOfPairs = new HashSet<>();

        while (startIndex < endIndex) {

            int result = arr[startIndex] + arr[endIndex];
            if (result == target) {
                Set<Integer> pair = new HashSet<>();
                pair.add(arr[startIndex]);
                pair.add(arr[endIndex]);
                listOfPairs.add(pair);
                startIndex++;
                endIndex--;
            }else if (result < target) {
                startIndex++;
            }else {
                endIndex--;
            }
        }
        return listOfPairs;

    }

}
