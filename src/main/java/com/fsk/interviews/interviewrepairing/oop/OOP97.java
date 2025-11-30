package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 97: Null ve polymorphism ultimate combination
 * 
 * Null reference + polymorphism + method overloading
 * En zor senaryo
 * Çıktı ne olur?
 */
class OOP97A {
    void method(Object o) {
        System.out.println("A method(Object)");
    }
    
    void method(String s) {
        System.out.println("A method(String)");
    }
    
    void method(Integer i) {
        System.out.println("A method(Integer)");
    }
}

class OOP97B extends OOP97A {
    void method(Double d) {
        System.out.println("B method(Double)");
    }
    
    @Override
    void method(Object o) {
        System.out.println("B method(Object)");
    }
    
    // method(String), method(Integer) inherit edilir
}

public class OOP97 {
    public static void main(String[] args) {
        OOP97A obj1 = new OOP97A();
        OOP97A obj2 = new OOP97B();
        OOP97B obj3 = new OOP97B();
        
        // obj1.method(null); // Ambiguous! String ve Integer eşit seviyede
        obj1.method((String) null);
        obj1.method((Integer) null);
        
        // obj2.method(null); // Ambiguous! String ve Integer eşit seviyede (compile-time tip A)
        obj2.method((String) null); // Trick!
        obj2.method((Integer) null); // Trick!
        
        // obj3.method(null); // Ambiguous! String, Integer, Double eşit seviyede
        obj3.method((String) null);
        obj3.method((Integer) null);
        obj3.method((Double) null);
    }
}

// ÇIKTI:
// A method(String)
// A method(Integer)
// A method(String) (compile-time tip A, method(String) var)
// A method(Integer) (compile-time tip A, method(Integer) var)
// A method(String) (compile-time tip B, method(String) inherit edilmiş)
// A method(Integer) (compile-time tip B, method(Integer) inherit edilmiş)
// B method(Double)
// Null resolution compile-time'da, override resolution runtime'da


