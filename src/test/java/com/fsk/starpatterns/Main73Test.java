package com.fsk.starpatterns;

import com.fsk.Main74;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main73Test {

    @Test
    void addStrings() {
        String num1 = "12345";
        String num2 = "100";
        String actual = Main74.addStrings(num1, num2);
        String expected = "12445";
        assertEquals(expected, actual);
    }
}