package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 23: Abstract class ve constructor
 * 
 * Abstract class'ın constructor'ı olabilir mi?
 * Abstract class'tan nesne oluşturulabilir mi?
 * Çıktı ne olur?
 */
abstract class OOP23A {
    int x;
    
    OOP23A(int x) {
        this.x = x;
        System.out.println("A constructor: " + x);
    }
    
    abstract void method();
}

class OOP23B extends OOP23A {
    OOP23B(int x) {
        super(x); // Abstract class constructor'ı çağrılmalı
        System.out.println("B constructor");
    }
    
    @Override
    void method() {
        System.out.println("B method(), x = " + x);
    }
}

public class OOP23 {
    public static void main(String[] args) {
        // OOP23A obj = new OOP23A(10); // HATA! Abstract class'tan nesne oluşturulamaz
        OOP23B obj = new OOP23B(20);
        obj.method();
    }
}

// ÇIKTI:
// A constructor: 20
// B constructor
// B method(), x = 20
// Abstract class'ın constructor'ı olabilir ama direkt nesne oluşturulamaz


