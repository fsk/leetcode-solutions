package com.fsk;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;



public class Main5Test extends TestCase {


    @Test
    public void testSingleNumber() {
        Main5 instance = new Main5();
        assertEquals(Main5.singleNumber((new int[]{1, 2, 4, 1, 3, 2, 4})), 3);
        assertEquals(Main5.singleNumber((new int[]{1})), 1);
    }
}