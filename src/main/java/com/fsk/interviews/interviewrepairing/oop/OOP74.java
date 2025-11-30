package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 74: Interface ve class method signature conflict
 * 
 * Interface abstract method vs class concrete method
 * Signature aynı ama farklı access modifier
 * Çıktı ne olur?
 */
interface OOP74A {
    void method(); // public abstract
}

abstract class OOP74B {
    void method() { // package-private
        System.out.println("B method()");
    }
}

class OOP74C extends OOP74B implements OOP74A {
    // Interface method public, class method package-private
    // Override zorunlu, public olmalı
    @Override
    public void method() {
        System.out.println("C method()");
        super.method(); // B'nin metodunu çağır
    }
}

public class OOP74 {
    public static void main(String[] args) {
        OOP74C obj = new OOP74C();
        obj.method();
        
        OOP74A obj2 = obj;
        obj2.method();
    }
}

// ÇIKTI:
// C method()
// B method()
// C method()
// Interface method public olmalı, class method override edilmeli


