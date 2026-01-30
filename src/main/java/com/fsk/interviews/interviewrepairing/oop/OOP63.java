package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 63: Polymorphism ve interface default method conflict
 * 
 * Multiple interface'den gelen default method conflict
 * Class ve interface method conflict
 * Çıktı ne olur?
 */
interface OOP63A {
    default void method() {
        System.out.println("A default method()");
    }
}

interface OOP63B {
    default void method() {
        System.out.println("B default method()");
    }
}

class OOP63C {
    public void method() {
        System.out.println("C concrete method()");
    }
}

class OOP63D extends OOP63C implements OOP63A, OOP63B {
    // Class method interface default method'u override eder
    // Interface conflict yok çünkü class method var
}

class OOP63E implements OOP63A, OOP63B {
    // Interface conflict! Override zorunlu
    @Override
    public void method() {
        OOP63A.super.method();
        OOP63B.super.method();
        System.out.println("E method()");
    }
}

public class OOP63 {
    public static void main(String[] args) {
        OOP63D obj1 = new OOP63D();
        obj1.method();
        
        OOP63E obj2 = new OOP63E();
        obj2.method();
    }
}

// ÇIKTI:
// C concrete method() (class method öncelikli)
// A default method()
// B default method()
// E method()
// Class method interface default method'u override eder




