package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 24: Interface default method ve static method
 * 
 * Interface'de default ve static metodlar olabilir.
 * Bunlar nasıl çağrılır?
 * Çıktı ne olur?
 */
interface OOP24A {
    default void defaultMethod() {
        System.out.println("A defaultMethod()");
    }
    
    static void staticMethod() {
        System.out.println("A staticMethod()");
    }
    
    void abstractMethod();
}

class OOP24B implements OOP24A {
    @Override
    public void abstractMethod() {
        System.out.println("B abstractMethod()");
    }
    
    // defaultMethod override edilebilir ama zorunlu değil
    @Override
    public void defaultMethod() {
        System.out.println("B defaultMethod()");
    }
}

public class OOP24 {
    public static void main(String[] args) {
        OOP24A.staticMethod(); // Interface üzerinden çağrılır
        // OOP24B.staticMethod(); // HATA! Static metod inherit edilmez
        
        OOP24B obj = new OOP24B();
        obj.defaultMethod(); // Instance üzerinden çağrılır
        obj.abstractMethod();
    }
}

// ÇIKTI:
// A staticMethod()
// B defaultMethod()
// B abstractMethod()
// Interface static metodlar sadece interface üzerinden çağrılır
// Default metodlar instance üzerinden çağrılır ve override edilebilir


