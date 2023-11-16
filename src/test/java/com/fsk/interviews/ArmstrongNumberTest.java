package com.fsk.interviews;

import com.fsk.Main4;
import junit.framework.TestCase;
import org.junit.Test;

public class ArmstrongNumberTest extends TestCase {

    @Test
    public void testArmstrongNumber() {
        assertTrue("Test Passed", ArmstrongNumber.isArmstrong(407));
        assertFalse("Test Passed", ArmstrongNumber.isArmstrong(1342));
        assertTrue("Test Passed", ArmstrongNumber.isArmstrong(54748));
        assertTrue("Test Passed", ArmstrongNumber.isArmstrong(54748));
        assertTrue("Test Passed", ArmstrongNumber.isArmstrong(153));
        assertTrue("Test Passed", ArmstrongNumber.isArmstrong(0));
        assertTrue("Test Passed", ArmstrongNumber.isArmstrong(5));
        assertFalse("Test Passed", ArmstrongNumber.isArmstrong(24));
        assertTrue("Test Passed", ArmstrongNumber.isArmstrong(1634));
        assertFalse("Test Passed", ArmstrongNumber.isArmstrong(12353));
    }

    @Test
    public void testPow() {
        assertEquals(16, ArmstrongNumber.pow(2,4));
        assertEquals(25, ArmstrongNumber.pow(5,2));
        assertEquals(1, ArmstrongNumber.pow(123912,0));
        assertEquals(1, ArmstrongNumber.pow(1,123123));
        assertEquals(225, ArmstrongNumber.pow(15,2));
        assertEquals(243, ArmstrongNumber.pow(3,5));
    }

}