package com.fsk.interviews.adobe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question1Test {

    @Test
    void main() {
    }

    @Test
    void twoSum() {

        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {0, 2};
        int[] result = Question1.twoSum(nums, target);
        assertArrayEquals(expected, result);
    }

    @Test
    void twoSum2() {

        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        int[] result = Question1.twoSum2(nums, target);
        assertArrayEquals(expected, result);
    }
}