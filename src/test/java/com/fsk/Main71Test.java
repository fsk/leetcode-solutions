package com.fsk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main71Test {

    @Test
    void reverseVowels() {

        String input = "IceCreAm";
        String expected = "AceCreIm";
        String actual = Main71.reverseVowels(input);
        assertEquals(expected, actual);

    }

    @Test
    void reverseVowels_test2() {

        String input = "leetcode";
        String expected = "leotcede";
        String actual = Main71.reverseVowels(input);
        assertEquals(expected, actual);

    }
}