package com.fsk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Question Can Construct
 */

public class Main67 {

    public static void main(String[] args) {

        //System.out.println(canConstruct("aksaray", "sakarya"));
        //System.out.println(canConstruct2("aksaray", "sakarya"));
        //System.out.println(canConstruct3("aksaray", "sakarya"));
        System.out.println(canConstruct4("aa", "aab"));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteCharArray = ransomNote.toCharArray();
        Arrays.sort(ransomNoteCharArray);
        char[] magazineCharArray = magazine.toCharArray();
        Arrays.sort(magazineCharArray);
        return Arrays.equals(ransomNoteCharArray, magazineCharArray);
    }


    public static boolean canConstruct2(String ransomNote, String magazine) {

        if (ransomNote.length() != magazine.length()) return false;

        StringBuilder sb = new StringBuilder(magazine);

        for (int i = 0; i <= ransomNote.length()  - 1; i++) {
            char c =  ransomNote.charAt(i);
            int idx = sb.indexOf(String.valueOf(c));
            if (idx == -1 ) return false;
            sb.deleteCharAt(idx);
        }
        return true;
    }


    public static boolean canConstruct3(String ransomNote, String magazine) {
        if (ransomNote.length() != magazine.length()) return false;
        return noteMap(ransomNote).equals(noteMap(magazine));
    }


    private static Map<Character, Integer> noteMap(String note) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < note.length(); i++) {
            if (!map.containsKey(note.charAt(i))) {
                map.put(note.charAt(i), 1);
            }else {
                map.put(note.charAt(i), map.get(note.charAt(i)) + 1);
            }

        }

        return map;
    }

    public static boolean canConstruct4(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int cnt = map.getOrDefault(c, 0);
            if (cnt == 0) return false;
            if (cnt == 1) map.remove(c);
            else map.put(c, cnt - 1);
        }

        return true;
    }
}
