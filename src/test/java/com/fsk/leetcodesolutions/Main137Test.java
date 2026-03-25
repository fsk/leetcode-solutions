package com.fsk.leetcodesolutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main137Test {

    @Test
    void main() {

        String s = Main137.defangIPaddr("1.1.1.1");
        assertEquals("1[.]1[.]1[.]1", s);
    }

}