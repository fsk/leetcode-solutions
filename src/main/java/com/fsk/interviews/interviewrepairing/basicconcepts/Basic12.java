package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 12: Object casting ve ClassCastException
 * 
 * Object casting nasıl çalışır?
 * Runtime vs compile-time checking
 * Çıktı ne olur?
 */
class Basic12A {
    void method() {
        System.out.println("A method()");
    }
}

class Basic12B extends Basic12A {
    @Override
    void method() {
        System.out.println("B method()");
    }
    
    void specificMethod() {
        System.out.println("B specificMethod()");
    }
}

class Basic12C extends Basic12A {
    @Override
    void method() {
        System.out.println("C method()");
    }
}

public class Basic12 {
    public static void main(String[] args) {
        Basic12A obj1 = new Basic12A();
        Basic12A obj2 = new Basic12B();
        Basic12A obj3 = new Basic12C();
        
        // Safe casting
        if (obj2 instanceof Basic12B) {
            Basic12B b = (Basic12B) obj2;
            b.specificMethod();
        }
        
        // Unsafe casting - ClassCastException
        try {
            Basic12B b2 = (Basic12B) obj3; // obj3 Basic12C, Basic12B değil
            b2.specificMethod();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
        
        // Compile-time vs runtime
        // Basic12B b3 = (Basic12B) obj1; // Compile OK, runtime exception
    }
}

// ÇIKTI:
// B specificMethod()
// ClassCastException: ...
// Casting compile-time'da kontrol edilmez, runtime'da kontrol edilir
// instanceof kontrolü ile safe casting yapılmalı


