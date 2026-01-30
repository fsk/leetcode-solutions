package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 66: Polymorphism ve static context
 * 
 * Static metod içinde polymorphism nasıl çalışır?
 * Static context'te this kullanılabilir mi?
 * Çıktı ne olur?
 */
class OOP66A {
    static void staticMethod() {
        System.out.println("A staticMethod()");
    }
    
    void instanceMethod() {
        System.out.println("A instanceMethod()");
    }
    
    static void callInstance(OOP66A obj) {
        obj.instanceMethod(); // Polymorphism çalışır
    }
}

class OOP66B extends OOP66A {
    static void staticMethod() { // Hide
        System.out.println("B staticMethod()");
    }
    
    @Override
    void instanceMethod() { // Override
        System.out.println("B instanceMethod()");
    }
}

public class OOP66 {
    public static void main(String[] args) {
        OOP66A.staticMethod();
        OOP66B.staticMethod();
        
        OOP66A obj = new OOP66B();
        obj.staticMethod(); // Compile-time tip
        obj.instanceMethod(); // Runtime tip
        
        OOP66A.callInstance(new OOP66B()); // Polymorphism çalışır
    }
}

// ÇIKTI:
// A staticMethod()
// B staticMethod()
// A staticMethod() (compile-time tip)
// B instanceMethod() (runtime tip)
// B instanceMethod()
// Static context'te polymorphism çalışmaz, instance context'te çalışır




