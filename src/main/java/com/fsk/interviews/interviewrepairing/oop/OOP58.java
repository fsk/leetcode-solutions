package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 58: Null ve ternary operator polymorphism
 * 
 * Ternary operator'da null nasıl davranır?
 * Type inference nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP58A {
    void method() {
        System.out.println("A method()");
    }
}

class OOP58B extends OOP58A {
    @Override
    void method() {
        System.out.println("B method()");
    }
}

public class OOP58 {
    public static void main(String[] args) {
        boolean condition = true;
        
        OOP58A obj1 = condition ? new OOP58A() : null;
        OOP58A obj2 = condition ? null : new OOP58B();
        OOP58A obj3 = condition ? new OOP58A() : new OOP58B();
        
        System.out.println("obj1 == null: " + (obj1 == null));
        System.out.println("obj2 == null: " + (obj2 == null));
        System.out.println("obj3 == null: " + (obj3 == null));
        
        if (obj1 != null) obj1.method();
        if (obj2 != null) obj2.method();
        if (obj3 != null) obj3.method();
        
        // Type inference
        Object obj4 = condition ? "String" : null;
        System.out.println("obj4 type: " + obj4.getClass().getSimpleName());
    }
}

// ÇIKTI:
// obj1 == null: false
// obj2 == null: true
// obj3 == null: false
// A method()
// A method()
// obj4 type: String
// Ternary operator'da null type inference'ı etkiler




