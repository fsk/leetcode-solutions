package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 15: Casting ve method overloading
 * 
 * Casting ile method overloading resolution
 * Çıktı ne olur?
 */
public class Basic15 {
    static void method(byte b) {
        System.out.println("method(byte): " + b);
    }
    
    static void method(short s) {
        System.out.println("method(short): " + s);
    }
    
    static void method(int i) {
        System.out.println("method(int): " + i);
    }
    
    static void method(long l) {
        System.out.println("method(long): " + l);
    }
    
    static void method(float f) {
        System.out.println("method(float): " + f);
    }
    
    static void method(double d) {
        System.out.println("method(double): " + d);
    }
    
    public static void main(String[] args) {
        byte b = 10;
        method(b); // method(byte)
        method((short) b); // method(short)
        method((int) b); // method(int)
        method((long) b); // method(long)
        method((float) b); // method(float)
        method((double) b); // method(double)
        
        // Without cast - widening
        method(b); // method(byte) - exact match
        int i = b;
        method(i); // method(int) - widening
    }
}

// ÇIKTI:
// method(byte): 10
// method(short): 10
// method(int): 10
// method(long): 10
// method(float): 10.0
// method(double): 10.0
// method(byte): 10
// method(int): 10
// Explicit cast ile exact match seçilir
// Widening otomatik yapılır


