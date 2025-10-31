package com.fsk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Main82Test {


    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 3",
            "3, 3",
            "4, 7",
            "5, 7",
            "6, 7",
            "7, 7",
            "8, 15",
            "10, 15",
            "16, 31",
            "31, 31",
            "33, 63",
            "1000, 1023"
    })
    void smallestNumber(int n, int expected) {
        assertEquals(expected, Main82.smallestNumber(n));
        assertEquals(expected, Main82.smallestNumber2(n));
        assertEquals(expected, Main82.smallestNumber3(n));
    }
}