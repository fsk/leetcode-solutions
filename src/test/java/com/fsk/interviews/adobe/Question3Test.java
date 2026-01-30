package com.fsk.interviews.adobe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question3Test {

    @Test
    void missingNumber_test1() {
        int[] input = new int[] {3,0,1};
        int expectedOutput = 2;
        int actualOutput = Question3.missingNumber(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void missingNumber_test2() {
        int[] input = new int[] {3,1,2};
        int expectedOutput = 0;
        int actualOutput = Question3.missingNumber(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void missingNumber_test3() {
        int[] input = new int[] {0,1};
        int expectedOutput = 2;
        int actualOutput = Question3.missingNumber(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void missingNumber_test4() {
        int[] input = new int[] {9,6,4,2,3,5,7,0,1};
        int expectedOutput = 8;
        int actualOutput = Question3.missingNumber(input);
        assertEquals(expectedOutput, actualOutput);
    }
}