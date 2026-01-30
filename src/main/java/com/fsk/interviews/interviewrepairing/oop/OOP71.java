package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 71: Multiple interface inheritance ve method resolution
 * 
 * Çoklu interface inheritance'da method resolution
 * Diamond problem interface'lerde
 * Çıktı ne olur?
 */
interface OOP71A {
    default void method() {
        System.out.println("A method()");
    }
}

interface OOP71B extends OOP71A {
    default void method() {
        System.out.println("B method()");
    }
}

interface OOP71C extends OOP71A {
    default void method() {
        System.out.println("C method()");
    }
}

interface OOP71D extends OOP71B, OOP71C {
    // Diamond problem! B ve C method() override etmiş
    // Override zorunlu
    @Override
    default void method() {
        // OOP71B.super.method(); // Illegal! Interface'de super çağrılamaz
        System.out.println("D method() - B ve C conflict, override zorunlu");
    }
}

class OOP71E implements OOP71D {
    // method() override edilebilir
}

public class OOP71 {
    public static void main(String[] args) {
        OOP71E obj = new OOP71E();
        obj.method();
    }
}

// ÇIKTI:
// Compile error: Illegal reference to super type
// Interface diamond problem'de super.method() çağrılamaz
// Override zorunlu ama super çağrısı yapılamaz

