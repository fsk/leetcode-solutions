package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 4: Widening vs autoboxing priority
 * 
 * Widening ve autoboxing hangisi öncelikli?
 * Çıktı ne olur?
 */
public class Basic4 {
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
    
    public static void main(String[] args) {
        byte b = 10;
        method(b); // Hangi metod? Widening mi autoboxing mi?
        
        short s = 20;
        method(s); // Hangi metod?
        
        char c = 'A';
        method(c); // Hangi metod?
    }
}

// ÇIKTI:
// method(int): 10 (widening byte -> int, autoboxing'den öncelikli)
// method(int): 20 (widening short -> int)
// method(int): 65 (widening char -> int, 'A' ASCII 65)
// Widening autoboxing'den önceliklidir
// byte/short/char -> int widening otomatik


