package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 72: Abstract class ve interface method conflict
 * 
 * Abstract class concrete method vs interface default method
 * Hangisi öncelikli?
 * Çıktı ne olur?
 */
abstract class OOP72A {
    public void method() {
        System.out.println("A concrete method()");
    }
    
    abstract void abstractMethod();
}

interface OOP72B {
    default void method() {
        System.out.println("B default method()");
    }
}

class OOP72C extends OOP72A implements OOP72B {
    @Override
    void abstractMethod() {
        System.out.println("C abstractMethod()");
    }
    
    // method() override edilebilir ama zorunlu değil
    // Class method interface default method'u override eder
}

public class OOP72 {
    public static void main(String[] args) {
        OOP72C obj = new OOP72C();
        obj.method(); // Hangi metod?
        obj.abstractMethod();
    }
}

// ÇIKTI:
// A concrete method() (class method öncelikli)
// C abstractMethod()
// Class concrete method interface default method'u override eder




