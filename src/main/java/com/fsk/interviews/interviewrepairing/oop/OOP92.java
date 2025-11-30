package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 92: Polymorphism ve constructor extreme chain
 * 
 * Çok katmanlı constructor chain
 * Her seviyede polimorfik metod
 * Çıktı ne olur?
 */
class OOP92A {
    int x = getValue();
    
    OOP92A() {
        System.out.println("A constructor, x = " + x);
        method();
    }
    
    int getValue() {
        System.out.println("A getValue()");
        return 1;
    }
    
    void method() {
        System.out.println("A method(), x = " + x);
    }
}

class OOP92B extends OOP92A {
    int x = getValue();
    int y = getValue();
    
    OOP92B() {
        System.out.println("B constructor, x = " + x + ", y = " + y);
        method();
    }
    
    int getValue() {
        System.out.println("B getValue()");
        return 2;
    }
    
    @Override
    void method() {
        System.out.println("B method(), x = " + x + ", y = " + y);
    }
}

class OOP92C extends OOP92B {
    int x = getValue();
    int z = getValue();
    
    OOP92C() {
        System.out.println("C constructor, x = " + x + ", z = " + z);
        method();
    }
    
    int getValue() {
        System.out.println("C getValue()");
        return 3;
    }
    
    @Override
    void method() {
        System.out.println("C method(), x = " + x + ", z = " + z);
    }
}

public class OOP92 {
    public static void main(String[] args) {
        new OOP92C();
    }
}

// ÇIKTI:
// A getValue() (A için x)
// A constructor, x = 1
// C method(), x = 0, y = 0, z = 0 (henüz initialize edilmedi!)
// B getValue() (B için x)
// B getValue() (B için y)
// B constructor, x = 2, y = 2
// C method(), x = 0, z = 0
// C getValue() (C için x)
// C getValue() (C için z)
// C constructor, x = 3, z = 3
// C method(), x = 3, z = 3
// Constructor chain'de her seviyede polimorfik metod çağrılır


