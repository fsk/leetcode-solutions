package com.fsk.leetcodesolutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main104Test {

    @Test
    void uncommonFromSentences() {

        String i1 = "this apple is sweet", i2 = "this apple is sour";
        String[] expectedArr = {"sweet","sour"};
        String[] actualArr = Main104.uncommonFromSentences(i1, i2);
        assertArrayEquals(expectedArr, actualArr);

    }


    @Test
    void uncommonFromSentences2() {

        String s1 = "apple apple", s2 = "banana";
        String[] expectedArr = {"banana"};
        String[] actualArr = Main104.uncommonFromSentences(s1, s2);
        assertArrayEquals(expectedArr, actualArr);

    }
}