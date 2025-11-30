package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 4: Constructor chaining ve this() vs super() çakışması
 * 
 * Constructor'da hem this() hem super() olamaz.
 * Ama dolaylı olarak nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP4A {
    OOP4A() {
        System.out.println("A()");
    }
    
    OOP4A(int x) {
        System.out.println("A(int): " + x);
    }
}

class OOP4B extends OOP4A {
    OOP4B() {
        this(10); // this() çağrıldığında super() otomatik çağrılmaz
        System.out.println("B()");
    }
    
    OOP4B(int x) {
        super(x); // super() açıkça çağrılmalı
        System.out.println("B(int): " + x);
    }
}

public class OOP4 {
    public static void main(String[] args) {
        new OOP4B();
    }
}

// ÇIKTI:
// A(int): 10
// B(int): 10
// B()
// this() çağrıldığında, o constructor'daki super() çalışır


