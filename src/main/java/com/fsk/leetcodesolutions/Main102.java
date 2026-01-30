package com.fsk.leetcodesolutions;

import java.util.*;

public class Main102 {

    public static void main(String[] args) {

        solution();


    }

    private static void solution() {
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            int random = (int)(Math.random() * 10 + 1);
            list.add(random);
        }

        System.out.println(list);

        int minIndex = 0;
        int maxIndex = list.size() - 1;
        int mid = minIndex + (maxIndex - minIndex) / 2;

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < mid; i++) {
            sum1 += list.get(i);
        }

        for (int i = mid; i < list.size(); i++) {
            sum2 += list.get(i);
        }

        if (sum1 < sum2) {
            System.out.println("rigth side is bigger then left side");
        }else {
            System.out.println("left side is bigger then right side");
        }
    }
}
