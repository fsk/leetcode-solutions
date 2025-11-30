package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 32: Abstract class ve interface birlikte implement
 * 
 * Bir class hem abstract class'tan extend hem interface'den implement edebilir.
 * Çakışma durumunda ne olur?
 * Çıktı ne olur?
 */
abstract class OOP32A {
    void method() {
        System.out.println("A method()");
    }
    
    abstract void abstractMethod();
}

interface OOP32B {
    default void method() {
        System.out.println("B method()");
    }
}

class OOP32C extends OOP32A implements OOP32B {
    // method() çakışması! Abstract class metodunu override etmek zorunlu
    // Interface default metodunu da override etmek zorunlu
    @Override
    public void method() {
        super.method(); // A'nın metodunu çağır
        OOP32B.super.method(); // B'nin metodunu çağır
        System.out.println("C method()");
    }
    
    @Override
    void abstractMethod() {
        System.out.println("C abstractMethod()");
    }
}

public class OOP32 {
    public static void main(String[] args) {
        OOP32C obj = new OOP32C();
        obj.method();
        obj.abstractMethod();
    }
}

// ÇIKTI:
// A method()
// B method()
// C method()
// C abstractMethod()
// Abstract class ve interface metod çakışmasında override zorunlu


