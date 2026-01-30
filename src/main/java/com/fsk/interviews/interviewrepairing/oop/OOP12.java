package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 12: Method overloading ve null argument trick
 * 
 * null argümanı hangi overload'a gider?
 * Ambiguity nasıl çözülür?
 * Çıktı ne olur?
 */
class OOP12Test {
    void method(Object o) {
        System.out.println("method(Object)");
    }
    
    void method(String s) {
        System.out.println("method(String)");
    }
    
    void method(Integer i) {
        System.out.println("method(Integer)");
    }
    
    void method2(String s) {
        System.out.println("method2(String)");
    }
    
    void method2(Object o) {
        System.out.println("method2(Object)");
    }
}

public class OOP12 {
    public static void main(String[] args) {
        OOP12Test test = new OOP12Test();
        // test.method(null); // Ambiguous! Compile error
        // test.method2(null); // Bu da ambiguous olurdu
        test.method2((String) null); // Explicit cast
        test.method2((Object) null); // Explicit cast
    }
}

// ÇIKTI:
// Compile error: reference to method is ambiguous
// method(String) ve method(Integer) eşit seviyede spesifik
// method2(String) ve method2(Object) arasında String daha spesifik, bu yüzden method2(String) çağrılır

