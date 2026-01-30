package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 13: Super keyword ve method chaining
 * 
 * super.method() ile parent metodunu çağırabiliriz.
 * Ama super.super.method() mümkün mü?
 * Çıktı ne olur?
 */
class OOP13A {
    void method() {
        System.out.println("A method()");
    }
}

class OOP13B extends OOP13A {
    @Override
    void method() {
        System.out.println("B method()");
        super.method(); // Parent metodunu çağır
    }
}

class OOP13C extends OOP13B {
    @Override
    void method() {
        System.out.println("C method()");
        super.method(); // OOP13B'nin metodunu çağırır
        // super.super.method(); // HATA! Mümkün değil
    }
}

public class OOP13 {
    public static void main(String[] args) {
        OOP13C obj = new OOP13C();
        obj.method();
    }
}

// ÇIKTI:
// C method()
// B method()
// A method()
// super sadece bir seviye yukarı gider, super.super mümkün değil


