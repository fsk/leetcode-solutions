package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 47: Ultimate method overloading trick
 * 
 * Method overloading + autoboxing + widening + varargs
 * Ambiguity resolution
 * Çıktı ne olur?
 */
public class Basic47 {
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
    
    static void method(Integer i) {
        System.out.println("method(Integer): " + i);
    }
    
    static void method(Long l) {
        System.out.println("method(Long): " + l);
    }
    
    static void method(Object o) {
        System.out.println("method(Object): " + o);
    }
    
    static void method(int... args) {
        System.out.println("method(int...): " + args.length);
    }
    
    public static void main(String[] args) {
        byte b = 10;
        method(b); // method(byte) - exact match
        
        short s = 20;
        method(s); // method(short) - exact match
        
        int i = 30;
        method(i); // method(int) - exact match
        
        method(40L); // method(long) - exact match
        
        method(new Integer(50)); // method(Integer) - exact match
        
        method(60); // method(int) - primitive öncelikli
        
        // Ambiguity?
        // method(null); // HATA! Ambiguous - Integer ve Long arasında
        
        method((Object) null); // method(Object) - explicit cast
    }
}

// ÇIKTI:
// method(byte): 10
// method(short): 20
// method(int): 30
// method(long): 40
// method(Integer): 50
// method(int): 60
// method(Object): null
// Overload resolution: Exact match > widening > autoboxing > varargs
// Null ambiguity multiple reference types arasında oluşur




