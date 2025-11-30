package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 93: Interface diamond problem ultimate
 * 
 * Çoklu interface inheritance
 * Diamond problem çözümü
 * Çıktı ne olur?
 */
interface OOP93A {
    default void method() {
        System.out.println("A method()");
    }
}

interface OOP93B extends OOP93A {
    default void method() {
        System.out.println("B method()");
    }
}

interface OOP93C extends OOP93A {
    default void method() {
        System.out.println("C method()");
    }
}

interface OOP93D extends OOP93B, OOP93C {
    // Diamond problem! B ve C method() override etmiş
    // Override zorunlu
    @Override
    default void method() {
        System.out.println("D method() - B ve C conflict resolved");
    }
}

interface OOP93E extends OOP93D {
    // method() override edilebilir
}

class OOP93F implements OOP93E {
    // method() override edilebilir
}

public class OOP93 {
    public static void main(String[] args) {
        OOP93F obj = new OOP93F();
        obj.method();
        
        OOP93A objA = obj;
        OOP93B objB = obj;
        OOP93C objC = obj;
        OOP93D objD = obj;
        
        objA.method();
        objB.method();
        objC.method();
        objD.method();
    }
}

// ÇIKTI:
// D method() - B ve C conflict resolved
// D method() - B ve C conflict resolved
// D method() - B ve C conflict resolved
// D method() - B ve C conflict resolved
// D method() - B ve C conflict resolved
// Interface diamond problem override ile çözülür


