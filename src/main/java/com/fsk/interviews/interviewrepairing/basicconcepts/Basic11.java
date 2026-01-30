package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 11: Primitive widening ve narrowing
 * 
 * Widening vs narrowing cast
 * Information loss
 * Çıktı ne olur?
 */
public class Basic11 {
    public static void main(String[] args) {
        // Widening - otomatik
        byte b = 10;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;
        System.out.println("Widening: " + d);
        
        // Narrowing - explicit cast gerekli
        double d2 = 100.9;
        float f2 = (float) d2;
        long l2 = (long) f2; // 100.9 -> 100 (truncate)
        int i2 = (int) l2;
        short s2 = (short) i2;
        byte b2 = (byte) s2;
        System.out.println("Narrowing: " + b2);
        
        // Information loss
        int large = 1000;
        byte small = (byte) large; // 1000 % 256 = 232
        System.out.println("Large to small: " + small);
        
        // Float to int
        float floatVal = 10.9f;
        int intVal = (int) floatVal; // Truncate, not round
        System.out.println("Float to int: " + intVal);
    }
}

// ÇIKTI:
// Widening: 10.0
// Narrowing: 100
// Large to small: -24 (1000 % 256 = 232, signed byte: -24)
// Float to int: 10 (truncate, not round)
// Widening otomatik, narrowing explicit cast gerekli
// Narrowing information loss yaratabilir


