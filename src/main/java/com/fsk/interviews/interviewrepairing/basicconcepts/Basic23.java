package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 23: String ve null comparison
 * 
 * Null String ile == ve equals()
 * NullPointerException riski
 * Çıktı ne olur?
 */
public class Basic23 {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "test";
        String s3 = null;
        
        // == comparison with null
        System.out.println("s1 == null: " + (s1 == null)); // true
        System.out.println("s1 == s3: " + (s1 == s3)); // true
        System.out.println("s1 == s2: " + (s1 == s2)); // false
        
        // equals() with null
        System.out.println("s2.equals(s1): " + s2.equals(s1)); // false (s2 null değil)
        // System.out.println("s1.equals(s2): " + s1.equals(s2)); // NullPointerException!
        
        // Safe equals
        System.out.println("Safe equals: " + (s1 != null && s1.equals(s2))); // false
        System.out.println("Objects.equals: " + java.util.Objects.equals(s1, s2)); // false
        
        // Null concatenation
        String result = s1 + "test"; // "nulltest"
        System.out.println("Null concatenation: " + result);
        
        // Null in ternary
        String ternary = s1 != null ? s1 : "default";
        System.out.println("Ternary: " + ternary);
    }
}

// ÇIKTI:
// s1 == null: true
// s1 == s3: true
// s1 == s2: false
// s2.equals(s1): false
// Safe equals: false
// Objects.equals: false
// Null concatenation: nulltest
// Ternary: default
// Null String ile == kullanılabilir, equals() NullPointerException fırlatır
// Objects.equals() null-safe'dir




