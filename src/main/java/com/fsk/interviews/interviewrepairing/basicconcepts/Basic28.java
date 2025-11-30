package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 28: String ve equals() implementation
 * 
 * String.equals() nasıl çalışır?
 * Null check ve content comparison
 * Çıktı ne olur?
 */
public class Basic28 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = "HELLO";
        String s5 = null;
        
        // equals() implementation
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (content)
        System.out.println("s1.equals(s4): " + s1.equals(s4)); // false (case sensitive)
        System.out.println("s1.equalsIgnoreCase(s4): " + s1.equalsIgnoreCase(s4)); // true
        
        // Null check
        System.out.println("s1.equals(s5): " + s1.equals(s5)); // false (null check in equals)
        // System.out.println("s5.equals(s1): " + s5.equals(s1)); // NullPointerException!
        
        // Objects.equals() - null safe
        System.out.println("Objects.equals(s1, s5): " + java.util.Objects.equals(s1, s5)); // false
        System.out.println("Objects.equals(s5, s5): " + java.util.Objects.equals(s5, s5)); // true
        
        // ContentEquals
        StringBuilder sb = new StringBuilder("hello");
        System.out.println("s1.contentEquals(sb): " + s1.contentEquals(sb)); // true
    }
}

// ÇIKTI:
// s1.equals(s2): true
// s1.equals(s3): true
// s1.equals(s4): false
// s1.equalsIgnoreCase(s4): true
// s1.equals(s5): false
// Objects.equals(s1, s5): false
// Objects.equals(s5, s5): true
// s1.contentEquals(sb): true
// String.equals() null check yapar, content karşılaştırır
// Objects.equals() null-safe'dir


