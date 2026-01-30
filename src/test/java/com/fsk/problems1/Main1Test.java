package com.fsk.problems1;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Main1Test extends TestCase {

    @Test
    public void testRunningSum() {


        assertArrayEquals(new int[]{1,3,6,10}, Main1.runningSum(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{1,2,3,4,5}, Main1.runningSum(new int[]{1,1,1,1,1}));
        assertArrayEquals(new int[]{3,4,6,16,17}, Main1.runningSum(new int[]{3,1,2,10,1}));

    }
}