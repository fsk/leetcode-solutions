package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 22: Multiple inheritance simulation ve diamond problem
 * 
 * Java multiple inheritance desteklemez ama interface ile simüle edilebilir.
 * Diamond problem nasıl çözülür?
 * Çıktı ne olur?
 */
interface OOP22A {
    default void method() {
        System.out.println("A method()");
    }
}

interface OOP22B {
    default void method() {
        System.out.println("B method()");
    }
}

class OOP22C implements OOP22A, OOP22B {
    // Diamond problem! Hangi method() çağrılacak?
    // Çözüm: Override etmek zorunlu
    @Override
    public void method() {
        OOP22A.super.method(); // A'nın metodunu çağır
        OOP22B.super.method(); // B'nin metodunu çağır
        System.out.println("C method()");
    }
}

public class OOP22 {
    public static void main(String[] args) {
        OOP22C obj = new OOP22C();
        obj.method();
    }
}

// ÇIKTI:
// A method()
// B method()
// C method()
// Diamond problem interface default method'larda override zorunlu kılar


