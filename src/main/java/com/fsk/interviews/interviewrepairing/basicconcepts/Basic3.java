package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 3: Method overloading ve autoboxing priority
 * 
 * Method overloading'de primitive vs wrapper priority
 * Çıktı ne olur?
 */
public class Basic3 {
    static void method(int x) {
        System.out.println("method(int): " + x);
    }
    
    static void method(Integer x) {
        System.out.println("method(Integer): " + x);
    }
    
    static void method(long x) {
        System.out.println("method(long): " + x);
    }

    static void method(Long x) {
        System.out.println("method(Long): " + x);
    }
    
    static void method(Object x) {
        System.out.println("method(Object): " + x);
    }
    
    public static void main(String[] args) {
        method(10); // Hangi metod?
        method(new Integer(10)); // Hangi metod?
        method(10L); // Hangi metod?
        method((Object) 10); // Hangi metod?
    }
}

// ÇIKTI:
// method(int): 10 (exact match - primitive öncelikli)
// method(Integer): 10 (exact match - wrapper)
// method(long): 10 (exact match - long)
// method(Object): 10 (exact match - Object)
// Overload resolution: Exact match > widening > autoboxing > varargs


