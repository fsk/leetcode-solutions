package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 2: Static method hiding vs instance method overriding
 * 
 * Static metodlar override edilemez, hide edilir.
 * Instance metodlar override edilir.
 * Çıktı ne olur?
 */
class OOP2A {
    static void staticMethod() {
        System.out.println("A staticMethod");
    }
    
    void instanceMethod() {
        System.out.println("A instanceMethod");
    }
}

class OOP2B extends OOP2A {
    static void staticMethod() {
        System.out.println("B staticMethod");
    }
    
    @Override
    void instanceMethod() {
        System.out.println("B instanceMethod");
    }
}

public class OOP2 {
    public static void main(String[] args) {
        OOP2A obj1 = new OOP2A();
        OOP2A obj2 = new OOP2B();
        OOP2B obj3 = new OOP2B();
        
        obj1.staticMethod();
        obj2.staticMethod(); // Hangi metod çağrılır?
        obj3.staticMethod();
        
        obj1.instanceMethod();
        obj2.instanceMethod(); // Hangi metod çağrılır?
        obj3.instanceMethod();
    }
}

// ÇIKTI:
// A staticMethod
// A staticMethod (compile-time tip önemli - hiding)
// B staticMethod
// A instanceMethod
// B instanceMethod (runtime tip önemli - overriding)
// B instanceMethod


