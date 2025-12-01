package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 83: Null ve ternary operator extreme case
 * 
 * Ternary operator'da null type inference
 * Complex type resolution
 * Çıktı ne olur?
 */
class OOP83A {
}

class OOP83B extends OOP83A {
}

public class OOP83 {
    public static void main(String[] args) {
        boolean condition = true;
        
        // Type inference
        Object obj1 = condition ? "String" : null;
        Object obj2 = condition ? null : "String";
        OOP83A obj3 = condition ? new OOP83A() : null;
        OOP83A obj4 = condition ? null : new OOP83B();
        
        System.out.println("obj1 type: " + (obj1 != null ? obj1.getClass().getSimpleName() : "null"));
        System.out.println("obj2 type: " + (obj2 != null ? obj2.getClass().getSimpleName() : "null"));
        System.out.println("obj3 type: " + (obj3 != null ? obj3.getClass().getSimpleName() : "null"));
        System.out.println("obj4 type: " + (obj4 != null ? obj4.getClass().getSimpleName() : "null"));
        
        // Ambiguous case
        // OOP83A obj5 = condition ? null : null; // Type inference yapılamaz
        OOP83A obj5 = condition ? (OOP83A) null : null;
    }
}

// ÇIKTI:
// obj1 type: String
// obj2 type: String
// obj3 type: OOP83A
// obj4 type: OOP83B
// Ternary operator'da null type inference'ı etkiler
// Her iki taraf null ise explicit cast gerekli




