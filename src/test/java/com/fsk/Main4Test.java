package com.fsk;

import junit.framework.TestCase;
import org.junit.Test;

public class Main4Test extends TestCase {

    @Test
    public void testSquare() {
        assertEquals("Test Passed", 2, Main4.square(8));
    }
}