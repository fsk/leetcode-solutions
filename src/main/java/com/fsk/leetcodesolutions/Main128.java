package com.fsk.leetcodesolutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LetCode 771. Jewels and Stones
 */

public class Main128 {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
        System.out.println(numJewelsInStones("abCd", "aabCCddEfabCded"));
    }

    public static int numJewelsInStones(String jewels, String stones) {

        char[] stonesArray = stones.toCharArray();
        Map<Character, Integer> stonesMap = new HashMap<>();

        for (char c : stonesArray) {
            if (stonesMap.containsKey(c)) {
                stonesMap.put(c, stonesMap.get(c) + 1);
            } else {
                stonesMap.put(c, 1);
            }
        }

        int count = 0;
        for (char c : jewels.toCharArray()) {
            if (stonesMap.containsKey(c)) {
                count = count + stonesMap.get(c);
            }
        }

        return count;

    }

    public static int numJewelsInStones2(String jewels, String stones) {

        Set<Character> jewelChar = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelChar.add(c);
        }

        int count = 0;
        for (char c : stones.toCharArray()) {
            if (jewelChar.contains(c)) {
                count++;
            }
        }

        return count;

    }

    public static int numJewelsInStones3(String jewels, String stones) {
        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);

            if (jewels.indexOf(ch) != -1) {
                count++;
            }
        }

        return count;
    }

}
