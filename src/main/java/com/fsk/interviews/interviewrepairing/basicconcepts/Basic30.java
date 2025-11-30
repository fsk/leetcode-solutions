package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 30: String ve hashCode() trick
 * 
 * String hashCode() implementation
 * == false ama hashCode() aynı
 * Çıktı ne olur?
 */
public class Basic30 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = "hello";
        
        System.out.println("s1 == s2: " + (s1 == s2)); // false
        System.out.println("s1 == s3: " + (s1 == s3)); // true
        
        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("s3.hashCode(): " + s3.hashCode());
        System.out.println("Same hashCode? " + (s1.hashCode() == s2.hashCode()));
        
        // hashCode() equals() ile uyumlu
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("hashCode equal: " + (s1.hashCode() == s2.hashCode())); // true
        
        // Hash collision example
        String s4 = "Aa";
        String s5 = "BB";
        System.out.println("s4.hashCode(): " + s4.hashCode());
        System.out.println("s5.hashCode(): " + s5.hashCode());
        System.out.println("Collision? " + (s4.hashCode() == s5.hashCode()));
    }
}

// ÇIKTI:
// s1 == s2: false
// s1 == s3: true
// s1.hashCode(): 99162322
// s2.hashCode(): 99162322
// s3.hashCode(): 99162322
// Same hashCode? true
// s1.equals(s2): true
// hashCode equal: true
// Collision? true
// String hashCode() content'e göre hesaplanır, == ile ilgisi yok
// Hash collision mümkündür (farklı string'ler aynı hashCode)


