package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 99: Ultimate inheritance chain challenge
 * 
 * 5 seviye inheritance
 * Her seviyede override
 * Constructor polymorphism
 * Çıktı ne olur?
 */
class OOP99A {
    int x = getValue();
    
    OOP99A() {
        System.out.println("A constructor, x = " + x);
        method();
    }
    
    int getValue() {
        return 1;
    }
    
    void method() {
        System.out.println("A method(), x = " + x);
    }
}

class OOP99B extends OOP99A {
    int x = getValue();
    
    OOP99B() {
        System.out.println("B constructor, x = " + x);
        method();
    }
    
    int getValue() {
        return 2;
    }
    
    @Override
    void method() {
        System.out.println("B method(), x = " + x);
    }
}

class OOP99C extends OOP99B {
    int x = getValue();
    
    OOP99C() {
        System.out.println("C constructor, x = " + x);
        method();
    }
    
    int getValue() {
        return 3;
    }
    
    @Override
    void method() {
        System.out.println("C method(), x = " + x);
    }
}

class OOP99D extends OOP99C {
    int x = getValue();
    
    OOP99D() {
        System.out.println("D constructor, x = " + x);
        method();
    }
    
    int getValue() {
        return 4;
    }
    
    @Override
    void method() {
        System.out.println("D method(), x = " + x);
    }
}

class OOP99E extends OOP99D {
    int x = getValue();
    
    OOP99E() {
        System.out.println("E constructor, x = " + x);
        method();
    }
    
    int getValue() {
        return 5;
    }
    
    @Override
    void method() {
        System.out.println("E method(), x = " + x);
    }
}

public class OOP99 {
    public static void main(String[] args) {
        new OOP99E();
    }
}

// ÇIKTI:
// A getValue() (A için x)
// A constructor, x = 1
// E method(), x = 0 (henüz initialize edilmedi!)
// B getValue() (B için x)
// B constructor, x = 2
// E method(), x = 0
// C getValue() (C için x)
// C constructor, x = 3
// E method(), x = 0
// D getValue() (D için x)
// D constructor, x = 4
// E method(), x = 0
// E getValue() (E için x)
// E constructor, x = 5
// E method(), x = 5
// Deep inheritance chain'de her seviyede polimorfik metod çağrılır


