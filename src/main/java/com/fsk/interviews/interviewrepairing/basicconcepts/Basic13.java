package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 13: Primitive ve wrapper casting trick
 * 
 * Primitive ve wrapper arasında casting
 * Autoboxing ile casting
 * Çıktı ne olur?
 */
public class Basic13 {
    public static void main(String[] args) {
        // Primitive casting
        int i = 100;
        long l = i; // Widening
        double d = l; // Widening
        float f = (float) d; // Narrowing
        
        // Wrapper casting - compile error!
        Integer integer = 100;
        // Long longVal = integer; // HATA! No direct cast
        Long longVal = (long) integer; // Unbox, cast, box
        Double doubleVal = (double) integer; // Unbox, cast, box
        
        System.out.println("longVal: " + longVal);
        System.out.println("doubleVal: " + doubleVal);
        
        // Mixed casting
        Integer intObj = 200;
        long primitive = intObj; // Unboxing (int -> long widening)
        Long longObj = primitive; // Autoboxing
        System.out.println("primitive: " + primitive);
        System.out.println("longObj: " + longObj);
        
        // Narrowing with wrapper
        Long large = 1000L;
        int small = large.intValue(); // Explicit conversion
        Integer smallObj = large.intValue(); // Unbox, narrow, box
        System.out.println("small: " + small);
        System.out.println("smallObj: " + smallObj);
    }
}

// ÇIKTI:
// longVal: 100
// doubleVal: 100.0
// primitive: 200
// longObj: 200
// small: 1000
// smallObj: 1000
// Wrapper'lar arasında direkt cast yok, unbox-cast-box gerekli


