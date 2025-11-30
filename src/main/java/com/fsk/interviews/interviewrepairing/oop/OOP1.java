package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 1: Constructor içinde polimorfik metod çağrısı ve instance variable initialization
 * 
 * Constructor içinde override edilmiş metod çağrıldığında ne olur?
 * Instance variable'lar ne zaman initialize edilir?
 * Çıktı ne olur?
 */
class OOP1A {
    int x = getValue();
    
    OOP1A() {
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

class OOP1B extends OOP1A {
    int x = getValue();
    int y = 20;
    
    OOP1B() {
        System.out.println("B constructor, x = " + x + ", y = " + y);
        print();
    }
    
    int getValue() {
        System.out.println("B getValue()");
        return 30;
    }
    
    void print() {
        System.out.println("B print(), x = " + x + ", y = " + y);
    }
}

public class OOP1 {
    public static void main(String[] args) {
        new OOP1B();
    }
}

// ÇIKTI:
// A getValue() (OOP1A için x initialize)
// A constructor, x = 10
// B print(), x = 0, y = 0 (OOP1B'deki x ve y henüz initialize edilmedi!)
// B getValue() (OOP1B için x initialize)
// B constructor, x = 30, y = 20
// B print(), x = 30, y = 20


