package com.fsk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main69Test {

    @Test
    void thirdMax_test1() {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        int actual = Main69.thirdMax(nums);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void thirdMax_test2() {
        int[] nums = new int[]{3,2,1};
        int actual = Main69.thirdMax(nums);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void thirdMax_test3() {
        int[] nums = new int[]{1,2};
        int actual = Main69.thirdMax(nums);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void thirdMax_test4() {
        int[] nums = new int[]{2,2,3,1};
        int actual = Main69.thirdMax(nums);
        int expected = 1;
        assertEquals(expected, actual);
    }
}