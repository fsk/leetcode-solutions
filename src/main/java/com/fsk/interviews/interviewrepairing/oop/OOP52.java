package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 52: Null ve polymorphism trick
 * 
 * Null bir tip olabilir mi?
 * Polymorphism'de null nasıl davranır?
 * Çıktı ne olur?
 */
class OOP52A {
    void method(OOP52A obj) {
        System.out.println("A method(A)");
    }
    
    void method(OOP52B obj) {
        System.out.println("A method(B)");
    }
}

class OOP52B extends OOP52A {
    @Override
    void method(OOP52A obj) {
        System.out.println("B method(A)");
    }
    
    @Override
    void method(OOP52B obj) {
        System.out.println("B method(B)");
    }
}

public class OOP52 {
    public static void main(String[] args) {
        OOP52A obj1 = new OOP52A();
        OOP52A obj2 = new OOP52B();
        OOP52A obj3 = null;
        
        obj1.method(null); // Hangi metod?
        obj2.method(null); // Hangi metod?
        obj3.method(null); // Hangi metod?
    }
}

// ÇIKTI:
// A method(A) (null Object olarak kabul edilir)
// B method(A) (null Object olarak kabul edilir, compile-time tip önemli)
// NullPointerException! (obj3 null)
// Null argümanı en genel tip olarak kabul edilir (Object)




