package com.fsk;

import java.util.TreeSet;

public class Main69 {

    public static void main(String[] args) {


    }

    public static int thirdMax(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) set.add(n);

        if (set.size() < 3) return set.last();

        set.pollLast();
        set.pollLast();
        return set.last();

    }
}
