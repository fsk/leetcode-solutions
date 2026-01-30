package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 64: Polymorphism ve generic type erasure trick
 * 
 * Generic type erasure polymorphism'i nasıl etkiler?
 * Bridge methods nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP64A {
    void method(Object obj) {
        System.out.println("A method(Object)");
    }
}

class OOP64B extends OOP64A {
    void method(String str) { // Overload, override değil!
        System.out.println("B method(String)");
    }
    
    @Override
    void method(Object obj) {
        System.out.println("B method(Object)");
    }
}

public class OOP64 {
    public static void main(String[] args) {
        OOP64A obj1 = new OOP64A();
        OOP64A obj2 = new OOP64B();
        
        obj1.method("test");
        obj2.method("test"); // Hangi metod?
        obj2.method((Object) "test"); // Hangi metod?
    }
}

// ÇIKTI:
// A method(Object)
// B method(Object) (compile-time tip önemli, method(String) görünmüyor)
// B method(Object)
// Generic type erasure sonrası method(String) method(Object) olur
// Overload resolution compile-time'da yapılır




