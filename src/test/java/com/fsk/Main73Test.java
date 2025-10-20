package com.fsk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main73Test {

    @Test
    void relativeSortArray() {

        //arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] expectedArray = {2,2,2,1,4,3,3,9,6,7,19};
        int[] actualArray = Main73.relativeSortArray(arr1, arr2);
        assertArrayEquals(expectedArray, actualArray);

    }
}