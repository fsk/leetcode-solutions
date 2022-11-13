package com.fsk.problems1;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Main2Test extends TestCase {

    @Test
    public void testPivotIndex() {

        Main2 instance = new Main2();

        assertEquals("Test", 3, instance.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}