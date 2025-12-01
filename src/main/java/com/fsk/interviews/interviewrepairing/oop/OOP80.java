package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 80: Complex inheritance ve method resolution
 * 
 * Çoklu inheritance simulation
 * Interface + Abstract class + Concrete class
 * Çıktı ne olur?
 */
interface OOP80A {
    default void method() {
        System.out.println("A default method()");
    }
}

abstract class OOP80B {
    public void method() {
        System.out.println("B concrete method()");
    }
    
    abstract void abstractMethod();
}

interface OOP80C {
    void method(); // Abstract metod
}

class OOP80D extends OOP80B implements OOP80A, OOP80C {
    // Class method (B) interface default method'u (A) override eder
    // Interface abstract method (C) implement edilmeli
    @Override
    public void method() {
        super.method(); // B'nin metodunu çağır
        System.out.println("D method()");
    }
    
    @Override
    void abstractMethod() {
        System.out.println("D abstractMethod()");
    }
}

public class OOP80 {
    public static void main(String[] args) {
        OOP80D obj = new OOP80D();
        obj.method();
        obj.abstractMethod();
        
        OOP80A objA = obj;
        OOP80C objC = obj;
        OOP80B objB = obj;
        
        objA.method();
        objC.method();
        objB.method();
    }
}

// ÇIKTI:
// B concrete method()
// D method()
// D abstractMethod()
// B concrete method()
// D method()
// B concrete method()
// D method()
// B concrete method()
// D method()
// Class concrete method en öncelikli, interface abstract method implement edilmeli




