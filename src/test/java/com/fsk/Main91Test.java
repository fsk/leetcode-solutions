package com.fsk;

import com.fsk.leetcodesolutions.Main91;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main91Test {

    @Test
    void findNumbers() {

        int numbers = Main91.findNumbers(new int[]{12, 345, 2, 6, 7896});
        assertEquals(2, numbers);

        int numbers2 = Main91.findNumbers2(new int[]{12, 345, 2, 6, 7896});
        assertEquals(2, numbers2);

    }
}