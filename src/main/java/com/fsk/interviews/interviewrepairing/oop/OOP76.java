package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 76: Constructor polymorphism trick
 * 
 * Constructor override edilemez ama polymorphism var mı?
 * Constructor chain'de polimorfik davranış
 * Çıktı ne olur?
 */
class OOP76A {
    OOP76A() {
        System.out.println("A constructor");
        method(); // Polimorfik metod çağrısı
    }
    
    void method() {
        System.out.println("A method()");
    }
}

class OOP76B extends OOP76A {
    OOP76B() {
        System.out.println("B constructor");
        method(); // Polimorfik metod çağrısı
    }
    
    @Override
    void method() {
        System.out.println("B method()");
    }
}

class OOP76C extends OOP76B {
    int x = getValue();
    
    OOP76C() {
        System.out.println("C constructor, x = " + x);
        method();
    }
    
    int getValue() {
        System.out.println("C getValue()");
        return 10;
    }
    
    @Override
    void method() {
        System.out.println("C method(), x = " + x);
    }
}

public class OOP76 {
    public static void main(String[] args) {
        new OOP76C();
    }
}

// ÇIKTI:
// A constructor
// C method(), x = 0 (henüz initialize edilmedi!)
// B constructor
// C method(), x = 0
// C getValue()
// C constructor, x = 10
// C method(), x = 10
// Constructor'da polimorfik metod çağrısı runtime tip'e göre çalışır


