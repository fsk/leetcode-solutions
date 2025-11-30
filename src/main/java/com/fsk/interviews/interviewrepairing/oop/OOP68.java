package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 68: Polymorphism ve method parameter
 * 
 * Method parameter'da polymorphism nasıl çalışır?
 * Overload vs override confusion
 * Çıktı ne olur?
 */
class OOP68A {
    void method(OOP68A obj) {
        System.out.println("A method(A)");
    }
    
    void method(OOP68B obj) {
        System.out.println("A method(B)");
    }
}

class OOP68B extends OOP68A {
    @Override
    void method(OOP68A obj) {
        System.out.println("B method(A)");
    }
    
    @Override
    void method(OOP68B obj) {
        System.out.println("B method(B)");
    }
}

class OOP68C extends OOP68B {
    @Override
    void method(OOP68A obj) {
        System.out.println("C method(A)");
    }
    
    // method(OOP68B) inherit edilir
}

public class OOP68 {
    public static void main(String[] args) {
        OOP68A obj1 = new OOP68A();
        OOP68A obj2 = new OOP68B();
        OOP68A obj3 = new OOP68C();
        OOP68B obj4 = new OOP68C();
        
        obj1.method(obj1);
        obj1.method(obj2);
        obj2.method(obj1); // Trick!
        obj2.method(obj2); // Trick!
        obj3.method(obj3); // Trick!
        obj4.method(obj4); // Trick!
    }
}

// ÇIKTI:
// A method(A)
// A method(B)
// B method(A) (obj2 runtime tip B, parameter compile-time tip A)
// B method(B) (obj2 runtime tip B, parameter compile-time tip B)
// C method(A) (obj3 runtime tip C, parameter compile-time tip A)
// C method(A) (obj4 runtime tip C, parameter compile-time tip B ama method(B) yok, method(A) var)
// Overload resolution compile-time'da, override resolution runtime'da


