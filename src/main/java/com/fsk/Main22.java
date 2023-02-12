package com.fsk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode -> 728. Self Dividing Numbers
 */

public class Main22 {

    public static void main(String[] args) {

        System.out.println(selfDividingNumbers(47, 85));

    }

    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> selfDividingNumberList = new ArrayList<>();

        List<Integer> rangeList = IntStream.rangeClosed(left, right).boxed().toList();
        for (int i = 0; i < rangeList.size(); i++) {
            if (selfDividing(rangeList.get(i))) {
                selfDividingNumberList.add(rangeList.get(i));
            }
        }

        return selfDividingNumberList;

    }
    public static boolean selfDividing(int num) {
        int count = 0;
        String intToString = String.valueOf(num);

        List<Integer> listInt = Arrays.stream(intToString
                        .split("\\B"))
                .map(Integer::valueOf).toList();

        for (int i = 0; i< listInt.size(); i++) {
            if (!listInt.contains(0) && num % listInt.get(i) == 0) {
                count++;
            }
        }

        return count == listInt.size();
    }

}
