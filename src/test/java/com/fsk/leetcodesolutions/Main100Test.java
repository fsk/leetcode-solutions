package com.fsk.leetcodesolutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main100Test {

    @Test
    void longestCommonPrefix() {

        String[] strs = {"flower","flow","flight"};
        assertEquals("fl", Main100.longestCommonPrefix(strs));
    }
}