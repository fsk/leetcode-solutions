package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 27: String ve == with method calls
 * 
 * Method return value ile == comparison
 * Çıktı ne olur?
 */
public class Basic27 {
    static String getString1() {
        return "hello";
    }
    
    static String getString2() {
        return new String("hello");
    }
    
    static String getString3() {
        String s = "hello";
        return s;
    }
    
    static String getString4() {
        String s = "hel";
        return s + "lo"; // Runtime concatenation
    }
    
    public static void main(String[] args) {
        String s1 = "hello";
        
        System.out.println("s1 == getString1(): " + (s1 == getString1())); // true (pool)
        System.out.println("s1 == getString2(): " + (s1 == getString2())); // false (new)
        System.out.println("s1 == getString3(): " + (s1 == getString3())); // true (pool)
        System.out.println("s1 == getString4(): " + (s1 == getString4())); // false (runtime)
        
        System.out.println("getString1() == getString3(): " + (getString1() == getString3())); // true
        
        // intern() ile
        String interned = getString2().intern();
        System.out.println("s1 == interned: " + (s1 == interned)); // true
    }
}

// ÇIKTI:
// s1 == getString1(): true
// s1 == getString2(): false
// s1 == getString3(): true
// s1 == getString4(): false
// getString1() == getString3(): true
// s1 == interned: true
// Method return value literal pool'dan gelirse == true
// Runtime concatenation heap'te oluşturulur


