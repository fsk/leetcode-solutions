package com.fsk;

import junit.framework.TestCase;
import org.junit.Test;

public class Main6Test extends TestCase {

    @Test
    public void testLengthOfLastWord() {

        assertEquals(8, Main6.lengthOfLastWord("Furkan Sahin Kulaksiz"));
        assertEquals(6, Main6.lengthOfLastWord("    Ankara     "));

    }
}