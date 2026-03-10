package com.fsk.denemeler;

import java.util.ArrayList;

public class Main5 {

    public static void main(String[] args) {
        computeLPSArray("ababc");
    }

    public static ArrayList<Integer> computeLPSArray(String pattern) {
        int n = pattern.length();
        ArrayList<Integer> lps = new ArrayList<>();
        for (int k = 0; k < n; k++) lps.add(0);

        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps.set(i, len);
                i++;
            } else {
                if (len != 0) {
                    // fall back in the pattern
                    len = lps.get(len - 1);
                } else {
                    lps.set(i, 0);
                    i++;
                }
            }
        }

        return lps;
    }

}
