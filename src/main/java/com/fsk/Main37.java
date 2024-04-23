package com.fsk;

import java.util.Arrays;

/**
 * LeetCode -> 242. Valid Anagram
 */

public class Main37 {

    static final int CHAR_COUNT = 256;

    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccac"));
    }

    //Stream Sorting
//    public static boolean isAnagram(String s, String t) {
//        List<Character> sCharList = new ArrayList<>(s.chars().mapToObj(item -> (char) item).sorted().toList());
//        List<Character> tCharList = new ArrayList<>(t.chars().mapToObj(item -> (char) item).sorted().toList());
//
//        return sCharList.equals(tCharList);
//
//    }


    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        return Arrays.equals(sCharArr, tCharArr);

    }

    static boolean areAnagrams(String str1, String str2) {
        // Eğer string'lerin uzunlukları eşit değilse, anagram olamazlar
        if (str1.length() != str2.length()) {
            return false;
        }

        // Harf sayımlarını tutacak iki dizi
        int[] count1 = new int[CHAR_COUNT];
        int[] count2 = new int[CHAR_COUNT];

        // İlk string için harfleri say
        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i)]++;
        }

        // İkinci string için harfleri say
        for (int i = 0; i < str2.length(); i++) {
            count2[str2.charAt(i)]++;
        }

        // Sayımları karşılaştır
        for (int i = 0; i < CHAR_COUNT; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        // Tüm kontroler başarılı ise, string'ler anagramdır
        return true;
    }
}
