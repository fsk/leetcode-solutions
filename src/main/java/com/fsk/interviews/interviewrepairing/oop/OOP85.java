package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 85: Null ve method chaining extreme
 * 
 * Null reference method chaining
 * Optional pattern simulation
 * Çıktı ne olur?
 */
class OOP85A {
    OOP85A getNext() {
        System.out.println("A getNext()");
        return null;
    }
    
    OOP85A getPrev() {
        System.out.println("A getPrev()");
        return this;
    }
    
    void method() {
        System.out.println("A method()");
    }
}

class OOP85B extends OOP85A {
    @Override
    OOP85B getNext() { // Covariant return type
        System.out.println("B getNext()");
        return null;
    }
    
    @Override
    void method() {
        System.out.println("B method()");
    }
}

public class OOP85 {
    public static void main(String[] args) {
        OOP85A obj = new OOP85B();
        
        // Safe chaining
        OOP85A next = obj.getNext();
        if (next != null) {
            next.method();
        }
        
        // Unsafe chaining
        // obj.getNext().method(); // NullPointerException!
        
        // Chaining with null check
        OOP85A chain = obj.getPrev();
        if (chain != null && chain.getNext() != null) {
            chain.getNext().method();
        }
    }
}

// ÇIKTI:
// B getNext()
// A getPrev()
// B getNext()
// Method chaining'de null check kritik
// Covariant return type polymorphism'i etkilemez


