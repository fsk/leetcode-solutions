package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 30: Polymorphism ve instanceof trick
 * 
 * instanceof ve polymorphism nasıl çalışır?
 * Cast işlemi ne zaman gerekir?
 * Çıktı ne olur?
 */
class OOP30A {
    void method() {
        System.out.println("A method()");
    }
}

class OOP30B extends OOP30A {
    @Override
    void method() {
        System.out.println("B method()");
    }
    
    void specificMethod() {
        System.out.println("B specificMethod()");
    }
}

public class OOP30 {
    public static void main(String[] args) {
        OOP30A obj = new OOP30B();
        
        System.out.println("obj instanceof OOP30A: " + (obj instanceof OOP30A));
        System.out.println("obj instanceof OOP30B: " + (obj instanceof OOP30B));
        
        obj.method(); // Polymorphism
        
        // obj.specificMethod(); // HATA! Compile-time tip OOP30A
        
        if (obj instanceof OOP30B) {
            OOP30B b = (OOP30B) obj; // Cast gerekli
            b.specificMethod();
        }
        
        // ClassCastException örneği
        OOP30A obj2 = new OOP30A();
        // OOP30B b2 = (OOP30B) obj2; // ClassCastException!
    }
}

// ÇIKTI:
// obj instanceof OOP30A: true
// obj instanceof OOP30B: true
// B method()
// B specificMethod()
// instanceof runtime'da kontrol eder, cast compile-time'da kontrol edilmez




