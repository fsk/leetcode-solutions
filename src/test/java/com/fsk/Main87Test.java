package com.fsk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main87Test {

    @Test
    void maximumWealth() {

        // Test 1: [[1,2,3],[3,2,1]] → 6
        int[][] accounts1 = {{1, 2, 3}, {3, 2, 1}};
        assertEquals(6, Main87.maximumWealth(accounts1));

        // Test 2: [[1,5],[7,3],[3,5]] → 10
        int[][] accounts2 = {{1, 5}, {7, 3}, {3, 5}};
        assertEquals(10, Main87.maximumWealth(accounts2));

        // Test 3: [[2,8,7],[7,1,3],[1,9,5]] → 17
        int[][] accounts3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        assertEquals(17, Main87.maximumWealth(accounts3));

        // Test 4: [[10,20,30]] → 60
        int[][] accounts4 = {{10, 20, 30}};
        assertEquals(60, Main87.maximumWealth(accounts4));

        // Test 5: [[5],[10],[3]] → 10
        int[][] accounts5 = {{5}, {10}, {3}};
        assertEquals(10, Main87.maximumWealth(accounts5));

        // Test 6: [[2,2],[1,3],[4,0]] → 4
        int[][] accounts6 = {{2, 2}, {1, 3}, {4, 0}};
        assertEquals(4, Main87.maximumWealth(accounts6));
    }

}