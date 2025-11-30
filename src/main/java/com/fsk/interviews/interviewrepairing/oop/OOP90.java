package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 90: Polymorphism ve static context extreme
 * 
 * Static metod içinde polymorphism
 * Static nested class polymorphism
 * Çıktı ne olur?
 */
class OOP90A {
    static void staticMethod() {
        System.out.println("A staticMethod()");
    }
    
    void instanceMethod() {
        System.out.println("A instanceMethod()");
    }
    
    static class StaticNested {
        void method(OOP90A obj) {
            obj.instanceMethod(); // Polymorphism çalışır
        }
    }
}

class OOP90B extends OOP90A {
    static void staticMethod() { // Hide
        System.out.println("B staticMethod()");
    }
    
    @Override
    void instanceMethod() { // Override
        System.out.println("B instanceMethod()");
    }
}

public class OOP90 {
    public static void main(String[] args) {
        OOP90A.staticMethod();
        OOP90B.staticMethod();
        
        OOP90A obj = new OOP90B();
        obj.staticMethod(); // Compile-time tip
        obj.instanceMethod(); // Runtime tip
        
        OOP90A.StaticNested nested = new OOP90A.StaticNested();
        nested.method(new OOP90A());
        nested.method(new OOP90B()); // Polymorphism çalışır
    }
}

// ÇIKTI:
// A staticMethod()
// B staticMethod()
// A staticMethod() (compile-time tip)
// B instanceMethod() (runtime tip)
// A instanceMethod()
// B instanceMethod()
// Static context'te polymorphism çalışmaz, instance context'te çalışır


