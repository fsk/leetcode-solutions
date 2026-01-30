package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 91: Ultimate polymorphism ve null combination
 * 
 * Null reference polymorphism
 * Method overloading null resolution
 * Çıktı ne olur?
 */
class OOP91A {
    void method(Object o) {
        System.out.println("A method(Object)");
    }
    
    void method(String s) {
        System.out.println("A method(String)");
    }
}

class OOP91B extends OOP91A {
    void method(Integer i) {
        System.out.println("B method(Integer)");
    }
    
    @Override
    void method(Object o) {
        System.out.println("B method(Object)");
    }
}

public class OOP91 {
    public static void main(String[] args) {
        OOP91A obj1 = new OOP91A();
        OOP91A obj2 = new OOP91B();
        OOP91B obj3 = new OOP91B();
        
        // obj1.method(null); // method(String) çağrılır (en spesifik)
        // obj2.method(null); // method(Object) çağrılır (compile-time tip)
        // obj3.method(null); // Ambiguous! String ve Integer eşit seviyede
        
        obj1.method((String) null);
        obj2.method((String) null);
        obj3.method((String) null);
        obj3.method((Integer) null);
    }
}

// ÇIKTI:
// A method(String)
// A method(Object) (compile-time tip önemli)
// A method(String) (compile-time tip önemli)
// B method(Integer)
// Null resolution compile-time'da yapılır, polymorphism runtime'da




