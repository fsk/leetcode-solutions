package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 43: Ultimate String trick
 * 
 * String pool + concatenation + intern()
 * Compile-time vs runtime
 * Çıktı ne olur?
 */
public class Basic43 {
    public static void main(String[] args) {
        // Compile-time constant
        final String s1 = "hello";
        final String s2 = "world";
        String s3 = s1 + s2; // Compile-time concatenation
        String s4 = "helloworld";
        System.out.println("s3 == s4: " + (s3 == s4)); // true
        
        // Runtime concatenation
        String s5 = "hello";
        String s6 = s5 + "world"; // Runtime
        System.out.println("s6 == s4: " + (s6 == s4)); // false
        
        // intern() trick
        String s7 = s6.intern();
        System.out.println("s7 == s4: " + (s7 == s4)); // true
        
        // Method return
        String s8 = getString();
        System.out.println("s8 == s4: " + (s8 == s4)); // true (literal pool)
        
        // new String
        String s9 = new String("helloworld");
        System.out.println("s9 == s4: " + (s9 == s4)); // false
        String s10 = s9.intern();
        System.out.println("s10 == s4: " + (s10 == s4)); // true
    }
    
    static String getString() {
        return "helloworld"; // Literal pool
    }
}

// ÇIKTI:
// s3 == s4: true
// s6 == s4: false
// s7 == s4: true
// s8 == s4: true
// s9 == s4: false
// s10 == s4: true
// Compile-time constant final variable'lar compile-time'da resolve edilir
// intern() pool'a ekler ve pool'dan döner




