package com.fsk.leetcodesolutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main104 {

    public static void main(String[] args) {

    }



    public static String[] uncommonFromSentences(String s1, String s2) {
        String concanateString = s1 + " " + s2;
        Map<String, Integer> map = new HashMap<>();
        String[] arr = concanateString.split(" ");
        for (String s : arr) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        return map.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList().toArray(new String[0]);
    }


    public static String[] uncommonFromSentences2(String s1, String s2) {
        Map<String, Integer> freq = new HashMap<>();

        for (String w : (s1 + " " + s2).split(" ")) {
            freq.merge(w, 1, Integer::sum);
        }

        return freq.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
