package com.fsk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main87 {

    public static void main(String[] args) {


    }

    public static int maximumWealth(int[][] accounts) {

        List<Integer> list = new ArrayList<>();

        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum = sum + i;
            }
            list.add(sum);
        }


        return Collections.max(list);
    }

    public static int maximumWealth2(int[][] accounts) {

        int maxWealth = 0;

        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum = sum + i;
            }
            maxWealth = Math.max(maxWealth, sum);
        }


        return maxWealth;
    }

    public static int maximumWealth3(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(arr -> Arrays.stream(arr).sum())
                .max()
                .getAsInt();
    }
}
