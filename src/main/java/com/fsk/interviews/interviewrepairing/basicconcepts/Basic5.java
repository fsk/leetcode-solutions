package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 5: Autoboxing ve null comparison
 * 
 * Null Integer ile comparison nasıl çalışır?
 * Çıktı ne olur?
 */
public class Basic5 {
    public static void main(String[] args) {
        Integer a = null;
        Integer b = 10;
        
        // == comparison
        System.out.println("a == b: " + (a == b)); // false
        System.out.println("a == null: " + (a == null)); // true
        
        // equals() - null check
        System.out.println("a.equals(b): " + (a != null && a.equals(b))); // false
        System.out.println("b.equals(a): " + b.equals(a)); // false (b null değil)
        
        // compareTo() - NullPointerException
        // int result = a.compareTo(b); // NullPointerException!
        
        // Unboxing - NullPointerException
        // int value = a; // NullPointerException!
        // if (a > 10) { } // NullPointerException!
        
        // Safe comparison
        if (a != null && a > 10) {
            System.out.println("a > 10");
        } else {
            System.out.println("a is null or <= 10");
        }
    }
}

// ÇIKTI:
// a == b: false
// a == null: true
// a.equals(b): false
// b.equals(a): false
// a is null or <= 10
// Null Integer ile unboxing yapılamaz, NullPointerException fırlatır


