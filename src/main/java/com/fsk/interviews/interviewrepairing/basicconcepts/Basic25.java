package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 25: String substring ve memory trick
 * 
 * substring() memory leak riski (eski Java)
 * Yeni Java'da nasıl çalışır?
 * Çıktı ne olur?
 */
public class Basic25 {
    public static void main(String[] args) {
        String large = "This is a very long string that contains many characters";
        
        // substring() - yeni String
        String sub = large.substring(0, 10);
        System.out.println("substring: " + sub);
        System.out.println("sub == large: " + (sub == large)); // false
        
        // Java 7+ substring() yeni char array oluşturur
        // Eski Java'da (Java 6-) aynı char array'i paylaşırdı (memory leak riski)
        
        // intern() kullanımı
        String interned = sub.intern();
        String literal = "This is a";
        System.out.println("interned == literal: " + (interned == literal)); // true
        
        // String operations
        String upper = large.toUpperCase(); // Yeni String
        String lower = large.toLowerCase(); // Yeni String
        System.out.println("upper length: " + upper.length());
        System.out.println("lower length: " + lower.length());
    }
}

// ÇIKTI:
// substring: This is a
// sub == large: false
// interned == literal: true
// upper length: 60
// lower length: 60
// substring() yeni String oluşturur (Java 7+)
// intern() pool'a ekler


