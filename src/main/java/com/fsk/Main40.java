package com.fsk;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode -> 389. Find the Difference
 */

public class Main40 {

    public static void main(String[] args) {
        findTheDifference("a", "aa");
    }

    public static char findTheDifference(String s, String t) {
        List<Character> sCharList = new ArrayList<>(s.chars().mapToObj(item -> (char)item).toList());
        List<Character> tCharList = new ArrayList<>(t.chars().mapToObj(item -> (char)item).toList());
        for (int i = 0; i < sCharList.size(); i++) {
            tCharList.remove(sCharList.get(i));
        }
        return tCharList.get(0);
    }
}
