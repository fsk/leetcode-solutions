package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 42: Ultimate casting trick
 * 
 * Multiple inheritance simulation + casting
 * Interface + class casting
 * Çıktı ne olur?
 */
interface Basic42I {
    void method();
}

class Basic42A {
    void method() {
        System.out.println("A method()");
    }
}

class Basic42B extends Basic42A implements Basic42I {
    @Override
    public void method() {
        System.out.println("B method()");
    }
}

public class Basic42 {
    public static void main(String[] args) {
        Basic42B obj = new Basic42B();
        
        // Upcasting
        Basic42A a = obj; // No cast needed
        Basic42I i = obj; // No cast needed
        
        // Downcasting
        Basic42B b1 = (Basic42B) a; // Explicit cast
        Basic42B b2 = (Basic42B) i; // Explicit cast
        
        // instanceof check
        if (a instanceof Basic42B) {
            Basic42B b3 = (Basic42B) a;
            b3.method();
        }
        
        // Interface casting
        Object obj2 = obj;
        Basic42I i2 = (Basic42I) obj2;
        i2.method();
        
        // Invalid cast
        try {
            Basic42A a2 = new Basic42A();
            Basic42B b4 = (Basic42B) a2; // ClassCastException!
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
    }
}

// ÇIKTI:
// B method()
// B method()
// ClassCastException: ...
// Upcasting otomatik, downcasting explicit cast gerekli
// instanceof kontrolü ile safe casting yapılmalı




