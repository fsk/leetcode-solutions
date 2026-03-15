package com.fsk.leetcodesolutions;

import java.util.List;

/**
 * LeetCode -> 422. Valid Word Square
 */

public class Main130 {

    public static void main(String[] args) {
        System.out.println(validWordSquare(List.of("abcd","bnrt","crmy","dtye")));
        System.out.println(validWordSquare(List.of("abcd","bnrt","crm","dt")));
        System.out.println(validWordSquare(List.of("ball","area","read","lady")));
        System.out.println(validWordSquare(List.of("abc", "b")));
    }


    public static boolean validWordSquare(List<String> words) {

        char[][] wordCharArray = new char[words.size()][words.size()];

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                wordCharArray[i][j] = word.charAt(j);
            }
        }

        for (int i = 0; i < wordCharArray.length; i++) {
            for (int j = 0; j < wordCharArray[i].length; j++) {
                if (wordCharArray[i][j] != wordCharArray[j][i]) return false;
            }
        }
        return true;
    }


    public static boolean validWordSquare_2(List<String> words) {

        for (int i = 0; i < words.size(); i++) {

            for (int j = 0; j < words.get(i).length(); j++) {

                if (j >= words.size() ||
                        i >= words.get(j).length() ||
                        words.get(i).charAt(j) != words.get(j).charAt(i)) {

                    return false;
                }
            }
        }

        return true;
    }



}
