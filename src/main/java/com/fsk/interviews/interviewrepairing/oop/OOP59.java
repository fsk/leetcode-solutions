package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 59: Null ve method chaining
 * 
 * Null reference üzerinden method chaining yapılabilir mi?
 * Optional pattern nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP59A {
    OOP59A getNext() {
        System.out.println("A getNext()");
        return null;
    }
    
    void method() {
        System.out.println("A method()");
    }
}

public class OOP59 {
    public static void main(String[] args) {
        OOP59A obj = new OOP59A();
        
        // Method chaining
        OOP59A next = obj.getNext();
        if (next != null) {
            next.method();
        }
        
        // Null check pattern
        OOP59A obj2 = null;
        if (obj2 != null && obj2.getNext() != null) {
            obj2.getNext().method();
        }
        
        // NullPointerException örneği
        OOP59A obj3 = null;
        // obj3.getNext().method(); // NullPointerException!
    }
}

// ÇIKTI:
// A getNext()
// Method chaining'de null check gerekli
// Short-circuit evaluation (&&) ile null check yapılabilir




