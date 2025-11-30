package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 94: Null ve method overriding extreme
 * 
 * Null return eden metod override
 * Covariant return type null
 * Çıktı ne olur?
 */
class OOP94A {
    OOP94A getInstance() {
        System.out.println("A getInstance()");
        return null;
    }
    
    String getName() {
        return null;
    }
}

class OOP94B extends OOP94A {
    @Override
    OOP94B getInstance() { // Covariant return type, null return
        System.out.println("B getInstance()");
        return null;
    }
    
    @Override
    String getName() {
        return null;
    }
}

class OOP94C extends OOP94B {
    @Override
    OOP94C getInstance() {
        System.out.println("C getInstance()");
        return null;
    }
}

public class OOP94 {
    public static void main(String[] args) {
        OOP94A obj1 = new OOP94A();
        OOP94A obj2 = new OOP94B();
        OOP94A obj3 = new OOP94C();
        
        OOP94A instance1 = obj1.getInstance();
        OOP94A instance2 = obj2.getInstance();
        OOP94A instance3 = obj3.getInstance();
        
        System.out.println("instance1 == null: " + (instance1 == null));
        System.out.println("instance2 == null: " + (instance2 == null));
        System.out.println("instance3 == null: " + (instance3 == null));
        
        String name = obj2.getName();
        // name.length(); // NullPointerException!
    }
}

// ÇIKTI:
// A getInstance()
// B getInstance()
// C getInstance()
// instance1 == null: true
// instance2 == null: true
// instance3 == null: true
// Null return eden metodlar override edilebilir, null check gerekli


