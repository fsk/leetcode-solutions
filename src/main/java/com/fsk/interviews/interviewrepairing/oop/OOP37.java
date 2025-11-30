package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 37: Interface default method ve abstract class
 * 
 * Interface default method ve abstract class normal method arasındaki fark nedir?
 * Hangisi ne zaman kullanılır?
 * Çıktı ne olur?
 */
interface OOP37A {
    default void defaultMethod() {
        System.out.println("A defaultMethod()");
    }
    
    void abstractMethod();
}

abstract class OOP37B {
    void concreteMethod() {
        System.out.println("B concreteMethod()");
    }
    
    abstract void abstractMethod();
}

class OOP37C implements OOP37A {
    @Override
    public void abstractMethod() {
        System.out.println("C abstractMethod()");
    }
    
    // defaultMethod override edilebilir ama zorunlu değil
}

class OOP37D extends OOP37B {
    @Override
    void abstractMethod() {
        System.out.println("D abstractMethod()");
    }
    
    // concreteMethod override edilebilir ama zorunlu değil
}

public class OOP37 {
    public static void main(String[] args) {
        OOP37C obj1 = new OOP37C();
        obj1.defaultMethod();
        obj1.abstractMethod();
        
        OOP37D obj2 = new OOP37D();
        obj2.concreteMethod();
        obj2.abstractMethod();
    }
}

// ÇIKTI:
// A defaultMethod()
// C abstractMethod()
// B concreteMethod()
// D abstractMethod()
// Interface default method ve abstract class concrete method benzer ama farklı kullanım alanları var


