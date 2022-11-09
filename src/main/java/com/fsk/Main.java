package com.fsk;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int arr[] = twoSum(new int[]{3,2,4}, 6);
        for (Integer item:
             arr) {
            System.out.println(item);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> indexList = new ArrayList<>();
        outsideFor:
        for (int i = 0; i <numList.size() ; i++) {
            insideFor:
            for (int j = 0; j <numList.size() ; j++) {
                if (numList.get(i) + numList.get(j) == target) {
                    if (i != j) {
                        indexList.add(i);
                        indexList.add(j);
                        break outsideFor;
                    }

                }
            }
        }
        return indexList.stream().mapToInt(Integer::intValue).toArray();
    }
}
