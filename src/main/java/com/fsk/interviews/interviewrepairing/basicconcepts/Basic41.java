package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 41: Ultimate boxing/unboxing trick
 * 
 * Method overloading + autoboxing + varargs
 * Priority resolution
 * Çıktı ne olur?
 */
public class Basic41 {
    static void method(int x) {
        System.out.println("method(int): " + x);
    }
    
    static void method(Integer x) {
        System.out.println("method(Integer): " + x);
    }
    
    // int... ve Integer... aynı signature (type erasure) - aynı anda kullanılamaz
    // static void method(int... args) { } // HATA! Ambiguous
    // static void method(Integer... args) { } // HATA! Ambiguous
    
    static void method2(int... args) {
        System.out.println("method2(int...): " + args.length);
    }
    
    public static void main(String[] args) {
        method(10); // Hangi metod? Exact match: method(int)
        method(Integer.valueOf(10)); // Hangi metod? Exact match: method(Integer)
        method2(10, 20); // Varargs: method2(int...)
        
        // NOT: int... ve Integer... aynı signature'a sahiptir (type erasure)
        // Bu yüzden aynı anda kullanılamaz - ambiguous error
    }
}

// ÇIKTI:
// method(int): 10
// method(Integer): 10
// method2(int...): 2
// Overload resolution: Exact match > widening > autoboxing > varargs
// Varargs en düşük önceliğe sahiptir
// NOT: int... ve Integer... aynı signature (type erasure) - ambiguous error

