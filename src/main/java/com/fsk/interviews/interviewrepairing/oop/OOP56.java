package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 56: Null ve method overriding trick
 * 
 * Null return eden metod override edilebilir mi?
 * Return type null olabilir mi?
 * Çıktı ne olur?
 */
class OOP56A {
    OOP56A getInstance() {
        System.out.println("A getInstance()");
        return null; // Null return edilebilir
    }
    
    String getName() {
        return "A";
    }
}

class OOP56B extends OOP56A {
    @Override
    OOP56B getInstance() { // Covariant return type, null return edebilir
        System.out.println("B getInstance()");
        return null;
    }
    
    @Override
    String getName() {
        return null; // Null return edilebilir
    }
}

public class OOP56 {
    public static void main(String[] args) {
        OOP56A obj = new OOP56B();
        OOP56A instance = obj.getInstance();
        System.out.println("instance == null: " + (instance == null));
        
        String name = obj.getName();
        System.out.println("name == null: " + (name == null));
        // System.out.println("name.length() = " + name.length()); // NullPointerException!
    }
}

// ÇIKTI:
// B getInstance()
// instance == null: true
// name == null: true
// Metodlar null return edebilir, null check yapılmalı




