package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 22: String concatenation ve == trick
 * 
 * String concatenation nasıl çalışır?
 * Compile-time vs runtime concatenation
 * Çıktı ne olur?
 */
public class Basic22 {
    public static void main(String[] args) {
        // Compile-time concatenation
        String s1 = "hello" + "world";
        String s2 = "helloworld";
        System.out.println("s1 == s2: " + (s1 == s2)); // true (compile-time)
        
        // Runtime concatenation
        String s3 = "hello";
        String s4 = s3 + "world";
        String s5 = "hello" + "world";
        System.out.println("s4 == s5: " + (s4 == s5)); // false (runtime)
        System.out.println("s4.equals(s5): " + s4.equals(s5)); // true
        
        // final variable - compile-time
        final String s6 = "hello";
        String s7 = s6 + "world";
        System.out.println("s7 == s5: " + (s7 == s5)); // true (final compile-time)
        
        // Non-final - runtime
        String s8 = "hello";
        String s9 = s8 + "world";
        System.out.println("s9 == s5: " + (s9 == s5)); // false (runtime)
    }
}

// ÇIKTI:
// s1 == s2: true
// s4 == s5: false
// s4.equals(s5): true
// s7 == s5: true
// s9 == s5: false
// Compile-time concatenation pool'da, runtime concatenation heap'te
// final variable compile-time constant olarak kabul edilir


