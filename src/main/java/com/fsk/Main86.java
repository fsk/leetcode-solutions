package com.fsk;

import java.util.*;

public class Main86 {

    public static void main(String[] args) {

    }

    public static int[] getSneakyNumbers(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }

        return new int[]{duplicates.get(0), duplicates.get(1)};
    }

}
