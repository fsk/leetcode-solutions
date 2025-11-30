package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 21: String literal pool ve == comparison
 * 
 * String literal pool nedir?
 * == vs equals() farkı
 * Çıktı ne olur?
 */
public class Basic21 {
    public static void main(String[] args) {
        // String literal pool
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        
        System.out.println("s1 == s2: " + (s1 == s2)); // true (pool)
        System.out.println("s1 == s3: " + (s1 == s3)); // false (new)
        System.out.println("s3 == s4: " + (s3 == s4)); // false (different objects)
        
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true
        System.out.println("s3.equals(s4): " + s3.equals(s4)); // true
        
        // intern() - pool'a ekle
        String s5 = s3.intern();
        System.out.println("s1 == s5: " + (s1 == s5)); // true (intern)
    }
}

// ÇIKTI:
// s1 == s2: true (literal pool)
// s1 == s3: false (new object)
// s3 == s4: false (different objects)
// s1.equals(s2): true
// s1.equals(s3): true
// s3.equals(s4): true
// s1 == s5: true
// String literal pool compile-time'da oluşturulur
// == referans karşılaştırması, equals() içerik karşılaştırması


