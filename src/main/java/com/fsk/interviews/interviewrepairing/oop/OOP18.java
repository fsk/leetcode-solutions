package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 18: Static method ve instance method aynı isim
 * 
 * Aynı isimde static ve instance metod olabilir mi?
 * Çıktı ne olur?
 */
class OOP18Test {
    static void method() {
        System.out.println("static method()");
    }
    
    void method(int x) {
        System.out.println("instance method(int): " + x);
    }
    
    static void method(String s) {
        System.out.println("static method(String): " + s);
    }
    
    void method(double d) {
        System.out.println("instance method(double): " + d);
    }
}

public class OOP18 {
    public static void main(String[] args) {
        OOP18Test.method(); // Static metod
        OOP18Test.method("test"); // Static metod
        
        OOP18Test obj = new OOP18Test();
        obj.method(10); // Instance metod
        obj.method(10.0); // Instance metod
        obj.method(); // Static metod (obj üzerinden çağrılabilir ama önerilmez)
    }
}

// ÇIKTI:
// static method()
// static method(String): test
// instance method(int): 10
// instance method(double): 10.0
// static method()
// Aynı isimde static ve instance metod olabilir, parametreler farklı olmalı


