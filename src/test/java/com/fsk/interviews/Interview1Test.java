package com.fsk.interviews;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class Interview1Test extends TestCase {

    @Test
    public void testDuplicateWords() {
        String msg = "ankarada dogdum ama ankarada yasamiyorum";
        List<String> stringList = List.of("ankarada");
        assertEquals(stringList, Interview1.duplicateWords(msg));
    }

    @Test
    public void testDuplicateWords2() {
        String msg = "turkiye java community ve community turkiye " +
                "java ama ayni zamanda da " +
                "community java turkiye";

        List<String> stringList = List.of("java", "turkiye", "community");
        assertEquals(stringList, Interview1.duplicateWords2(msg));
    }
}