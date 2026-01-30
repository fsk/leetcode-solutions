package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 55: Null ve field access
 * 
 * Null reference üzerinden field'a erişilebilir mi?
 * Static field null üzerinden erişilebilir mi?
 * Çıktı ne olur?
 */
class OOP55Test {
    static int staticField = 10;
    int instanceField = 20;
    
    static void staticMethod() {
        System.out.println("Static: " + staticField);
    }
}

public class OOP55 {
    public static void main(String[] args) {
        OOP55Test obj = null;
        
        System.out.println("obj.staticField = " + obj.staticField); // Null üzerinden static field!
        // System.out.println("obj.instanceField = " + obj.instanceField); // NullPointerException!
        
        obj.staticMethod(); // Null üzerinden static metod!
        
        System.out.println("obj == null: " + (obj == null));
    }
}

// ÇIKTI:
// obj.staticField = 10
// Static: 10
// obj == null: true
// Static field ve metod null üzerinden erişilebilir (derleyici uyarı verir)
// Instance field ve metod null üzerinden erişilemez


