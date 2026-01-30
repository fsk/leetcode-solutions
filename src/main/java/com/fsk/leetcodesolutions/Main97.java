package com.fsk.leetcodesolutions;

import java.util.ArrayList;
import java.util.List;

public class Main97 {

    public static void main(String[] args) {
        System.out.println(subset(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subset(int[] numArray) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtracking(numArray, 0, current, result);

        return result;
    }

    public static void backtracking(int[] numArray, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < numArray.length; i++) {
            current.add(numArray[i]);
            backtracking(numArray, i + 1, current, result);
            current.remove(current.size() - 1);


        }
    }
}
