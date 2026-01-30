package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 31: Interface constant ve variable hiding
 * 
 * Interface'deki constant'lar final static'tir.
 * Inheritance ile nasıl çalışır?
 * Çıktı ne olur?
 */
interface OOP31A {
    int VALUE = 10; // public static final
}

interface OOP31B extends OOP31A {
    int VALUE = 20; // Hide
}

class OOP31C implements OOP31B { // OOP31A zaten OOP31B'de var
    static int VALUE = 30; // Hide edilebilir (static olmalı)
}

public class OOP31 {
    public static void main(String[] args) {
        System.out.println("OOP31A.VALUE = " + OOP31A.VALUE);
        System.out.println("OOP31B.VALUE = " + OOP31B.VALUE);
        System.out.println("OOP31C.VALUE = " + OOP31C.VALUE); // Hangi değer?
        
        OOP31C obj = new OOP31C();
        // System.out.println("obj.VALUE = " + obj.VALUE); // Ambiguous!
        System.out.println("obj.VALUE (A) = " + OOP31A.VALUE);
        System.out.println("obj.VALUE (B) = " + OOP31B.VALUE);
    }
}

// ÇIKTI:
// OOP31A.VALUE = 10
// OOP31B.VALUE = 20
// OOP31C.VALUE = 20 (en spesifik interface'den)
// Interface constant'lar hide edilir, compile-time tip önemli

