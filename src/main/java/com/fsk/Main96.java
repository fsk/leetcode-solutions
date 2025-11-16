package com.fsk;

import java.util.ArrayList;
import java.util.List;

public class Main96 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = combination(nums, 2);

        System.out.println(result);
    }


    public static List<List<Integer>> combination(int[] numsArray, int combinationNumber) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtracking(numsArray, combinationNumber, 0, current, output);
        return output;
    }

    private static void backtracking(int[] numsArray, int combinationNumber, int start, List<Integer> current, List<List<Integer>> output) {

        if (current.size() == combinationNumber) {
            output.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < numsArray.length; i++) {
            current.add(numsArray[i]);
            backtracking(numsArray, combinationNumber, i + 1, current, output);
            current.remove(current.size() - 1);
        }
    }

}
