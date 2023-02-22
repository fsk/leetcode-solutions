package com.fsk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * LeetCode -> 500. Keyboard Row
 */

public class Main38 {

    public static void main(String[] args) {

        String[] arr = findWords(new String[]{"Hello","Alaska","Dad","Peace"});
        //String[] arr = findWords(new String[]{"adsdf","sfd"});
        //String[] arr = findWords(new String[]{"omk"});

        for (String item : arr) {
            System.out.println(item);
        }


    }

    public static String[] findWords(String[] words) {

        List<Character> row1 = List.of('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P');
        List<Character> row2 = List.of('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L');
        List<Character> row3 = List.of('Z', 'X', 'C', 'V', 'B', 'N', 'M');

        List<String> wordList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            List<Character> characterList = words[i].chars().map(Character::toUpperCase).mapToObj(item -> (char) item).toList();
            if (
                    new HashSet<>(row1).containsAll(characterList) ||
                    new HashSet<>(row2).containsAll(characterList) ||
                    new HashSet<>(row3).containsAll(characterList)) {
                wordList.add(words[i]);
            }
        }

        return wordList.toArray(String[]::new);

    }
}
