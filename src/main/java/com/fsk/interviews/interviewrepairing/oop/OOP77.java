package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 77: Interface default method ve abstract class conflict
 * 
 * Interface default method vs abstract class abstract method
 * Hangisi öncelikli?
 * Çıktı ne olur?
 */
interface OOP77A {
    default void method() {
        System.out.println("A default method()");
    }
}

abstract class OOP77B {
    abstract void method(); // Abstract metod
}

class OOP77C extends OOP77B implements OOP77A {
    // Abstract metod implement edilmeli
    @Override
    public void method() {
        System.out.println("C method()");
    }
}

public class OOP77 {
    public static void main(String[] args) {
        OOP77C obj = new OOP77C();
        obj.method();
    }
}

// ÇIKTI:
// C method()
// Abstract class abstract method interface default method'u override eder
// Abstract metod implement edilmeli




