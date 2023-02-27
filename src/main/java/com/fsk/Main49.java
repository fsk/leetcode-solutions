package com.fsk;

/**
 * LeetCode -> 1816. Truncate Sentence
 */

public class Main49 {

    public static void main(String[] args) {
        truncateSentence("Hello how are you Contestant", 4);
    }

    public static String truncateSentence(String s, int k) {
        
        String[] arr = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < k; i++) {
            str.append(" ").append(arr[i]);
        }
        return str.delete(0, 1).toString();
    }

}
