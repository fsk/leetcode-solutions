package com.fsk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main70Test {

    @Test
    void hammingWeight_test1() {
        int input = 11;
        int actual = Main70.hammingWeight(input);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void hammingWeight_test2() {
        int input = 128;
        int actual = Main70.hammingWeight(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void hammingWeight_test3() {
        int input = 2147483645;
        int actual = Main70.hammingWeight(input);
        int expected = 30;
        assertEquals(expected, actual);
    }
}