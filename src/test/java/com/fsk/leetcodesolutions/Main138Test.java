package com.fsk.leetcodesolutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main138Test {

    @Test
    void main() {

        String s = Main138.convertDateToBinary("2080-02-29");
        assertEquals("100000100000-10-11101", s);
    }
}