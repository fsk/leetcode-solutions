package com.fsk.leetcodesolutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main109Test {

    @Test
    void strStr() {
        String haystack = "hello", needle = "ll";
        int actual = Main109.strStr(haystack, needle);
        int expected = 2;
        assertEquals(expected, actual);

        haystack = "aaaaa";
        needle = "bba";
        actual = Main109.strStr(haystack, needle);
        expected = -1;
        assertEquals(expected, actual);

        haystack = "leetcode";
        needle = "leeto";
        actual = Main109.strStr(haystack, needle);
        expected = 0;
        assertEquals(expected, actual);

        haystack = "sadbutsad";
        needle = "sad";
        actual = Main109.strStr(haystack, needle);
        expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    void strStr2() {
        String haystack = "hello", needle = "ll";
        int actual = Main109.strStr2(haystack, needle);
        int expected = 2;
        assertEquals(expected, actual);

        haystack = "Merhaba Dünya";
        needle = "Dünya";
        actual = Main109.strStr2(haystack, needle);
        expected = 8;
        assertEquals(expected, actual);

        haystack = "hello";
        needle = "ll";
        actual = Main109.strStr2(haystack, needle);
        expected = 2;
        assertEquals(expected, actual);

    }


}