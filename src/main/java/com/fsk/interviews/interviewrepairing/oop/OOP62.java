package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 62: Polymorphism ve constructor call chain
 * 
 * Constructor chain'inde polimorfik metod çağrısı
 * Her seviyede farklı davranış
 * Çıktı ne olur?
 */
class OOP62A {
    int x = getValue();
    
    OOP62A() {
        System.out.println("A constructor, x = " + x);
        print();
    }
    
    int getValue() {
        System.out.println("A getValue()");
        return 10;
    }
    
    void print() {
        System.out.println("A print(), x = " + x);
    }
}

class OOP62B extends OOP62A {
    int x = getValue();
    int y = 20;
    
    OOP62B() {
        System.out.println("B constructor, x = " + x + ", y = " + y);
        print();
    }
    
    int getValue() {
        System.out.println("B getValue()");
        return 30;
    }
    
    @Override
    void print() {
        System.out.println("B print(), x = " + x + ", y = " + y);
    }
}

class OOP62C extends OOP62B {
    int x = getValue();
    int z = 40;
    
    OOP62C() {
        System.out.println("C constructor, x = " + x + ", z = " + z);
        print();
    }
    
    int getValue() {
        System.out.println("C getValue()");
        return 50;
    }
    
    @Override
    void print() {
        System.out.println("C print(), x = " + x + ", z = " + z);
    }
}

public class OOP62 {
    public static void main(String[] args) {
        new OOP62C();
    }
}

// ÇIKTI:
// A getValue() (A için x)
// A constructor, x = 10
// C print(), x = 0, y = 0, z = 0 (henüz initialize edilmedi!)
// B getValue() (B için x)
// B constructor, x = 30, y = 20
// C print(), x = 0, z = 0 (henüz initialize edilmedi!)
// C getValue() (C için x)
// C constructor, x = 50, z = 40
// C print(), x = 50, z = 40




