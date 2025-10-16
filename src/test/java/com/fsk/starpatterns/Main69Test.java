package com.fsk.starpatterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main69Test {

    @Test
    void addStrings() {
        String num1 = "12345";
        String num2 = "100";
        String actual = Main69.addStrings(num1, num2);
        String expected = "12445";
        assertEquals(expected, actual);
    }
}