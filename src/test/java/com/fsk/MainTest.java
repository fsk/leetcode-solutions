package com.fsk;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MainTest extends TestCase {

    @Test
    public void testTwoSum() {
        //assertArrayEquals(new L}, Main.twoSum(new int[]{2,7,11,15}, 9));
        //assertArrayEquals(new int[]{1,2}, Main.twoSum(new int[]{3,2,4}, 6));
    }

    @Test
    public void isPalindrome() {
        Assert.assertTrue("Test Passed", Main2.isPalindrome(121));
    }
}