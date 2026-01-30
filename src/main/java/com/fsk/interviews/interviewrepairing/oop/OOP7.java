package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 7: Method overloading ve inheritance trick
 * 
 * Overload resolution compile-time'da yapılır.
 * Inheritance ile nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP7A {
    void method(Object o) {
        System.out.println("A method(Object)");
    }
}

class OOP7B extends OOP7A {
    void method(String s) {
        System.out.println("B method(String)");
    }
}

public class OOP7 {
    public static void main(String[] args) {
        OOP7A obj1 = new OOP7A();
        OOP7A obj2 = new OOP7B();
        OOP7B obj3 = new OOP7B();
        
        obj1.method("test");
        obj2.method("test"); // Trick!
        obj3.method("test");
    }
}

// ÇIKTI:
// A method(Object) (compile-time tip: OOP7A, method(String) yok)
// A method(Object) (compile-time tip: OOP7A, method(String) görünmüyor)
// B method(String) (compile-time tip: OOP7B, method(String) var)
// Overload resolution compile-time'da yapılır, runtime tip önemli değil


