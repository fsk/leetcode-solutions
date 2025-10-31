package com.fsk;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Main86Test {

    @Test
    void getSneakyNumbers() {

        int[] expectedArray1 = Main86.getSneakyNumbers(new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2});
        int[] actualArray1 = new int[]{4,5};
        assertArrayEquals(expectedArray1, actualArray1);

        int[] expectedArray2 = Main86.getSneakyNumbers(new int[]{0,1,1,0});
        int[] actualArray2 = new int[]{0,1};
        assertArrayEquals(expectedArray2, actualArray2);

        int[] expectedArray3 = Main86.getSneakyNumbers(new int[]{0,3,2,1,3,2});
        int[] actualArray3 = new int[]{2,3};
        assertArrayEquals(expectedArray3, actualArray3);

    }
}