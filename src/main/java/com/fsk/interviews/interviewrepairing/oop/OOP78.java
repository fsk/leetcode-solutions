package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 78: Multiple interface ve same method signature
 * 
 * Birden fazla interface aynı metod signature'ına sahip
 * Default method conflict
 * Çıktı ne olur?
 */
interface OOP78A {
    default void method(int x) {
        System.out.println("A method(int)");
    }
}

interface OOP78B {
    default void method(int x) {
        System.out.println("B method(int)");
    }
}

interface OOP78C {
    void method(int x); // Abstract metod
}

class OOP78D implements OOP78A, OOP78B {
    // Conflict! Override zorunlu
    @Override
    public void method(int x) {
        OOP78A.super.method(x);
        OOP78B.super.method(x);
        System.out.println("D method(int)");
    }
}

class OOP78E implements OOP78A, OOP78C {
    // Abstract metod öncelikli, implement edilmeli
    @Override
    public void method(int x) {
        System.out.println("E method(int)");
    }
}

public class OOP78 {
    public static void main(String[] args) {
        OOP78D obj1 = new OOP78D();
        obj1.method(10);
        
        OOP78E obj2 = new OOP78E();
        obj2.method(20);
    }
}

// ÇIKTI:
// A method(int)
// B method(int)
// D method(int)
// E method(int)
// Default method conflict'te override zorunlu
// Abstract metod öncelikli


