package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 26: String ve StringBuilder performance
 * 
 * String vs StringBuilder concatenation
 * Performance farkı
 * Çıktı ne olur?
 */
public class Basic26 {
    public static void main(String[] args) {
        // String concatenation - yavaş
        long start1 = System.currentTimeMillis();
        String result1 = "";
        for (int i = 0; i < 10000; i++) {
            result1 += i; // Her iterasyonda yeni String!
        }
        long time1 = System.currentTimeMillis() - start1;
        System.out.println("String concatenation: " + time1 + "ms");
        
        // StringBuilder - hızlı
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(i); // Aynı object'e ekle
        }
        String result2 = sb.toString();
        long time2 = System.currentTimeMillis() - start2;
        System.out.println("StringBuilder: " + time2 + "ms");
        
        // Compiler optimization
        String optimized = "a" + "b" + "c"; // Compile-time: "abc"
        System.out.println("Optimized: " + optimized);
    }
}

// ÇIKTI:
// String concatenation: (çok yavaş - her iterasyonda yeni String)
// StringBuilder: (çok hızlı - aynı object)
// Optimized: abc
// String concatenation loop içinde çok yavaştır
// StringBuilder loop içinde kullanılmalıdır
// Compiler compile-time concatenation'ı optimize eder




