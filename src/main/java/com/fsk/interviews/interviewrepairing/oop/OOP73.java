package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 73: Deep inheritance ve method resolution
 * 
 * Çok katmanlı inheritance'da method resolution
 * Override chain nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP73A {
    void method() {
        System.out.println("A method()");
    }
}

class OOP73B extends OOP73A {
    @Override
    void method() {
        System.out.println("B method()");
        super.method();
    }
}

class OOP73C extends OOP73B {
    @Override
    void method() {
        System.out.println("C method()");
        super.method();
    }
}

class OOP73D extends OOP73C {
    @Override
    void method() {
        System.out.println("D method()");
        super.method();
    }
}

public class OOP73 {
    public static void main(String[] args) {
        OOP73A obj1 = new OOP73A();
        OOP73A obj2 = new OOP73B();
        OOP73A obj3 = new OOP73C();
        OOP73A obj4 = new OOP73D();
        
        obj1.method();
        obj2.method();
        obj3.method();
        obj4.method();
    }
}

// ÇIKTI:
// A method()
// B method()
// A method()
// C method()
// B method()
// A method()
// D method()
// C method()
// B method()
// A method()
// super.method() chain'i yukarı doğru çağırır


