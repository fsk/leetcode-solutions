package com.fsk.interviews;

import java.util.HashMap;
import java.util.Map;

public class Interview3 {

    public static void main(String[] args) {

        System.out.println(solution("sakarya", "aksaray"));
    }


    public static boolean solution(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : a.toLowerCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : b.toLowerCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) return false;
        }

        return true;
    }
}
