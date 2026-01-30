package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 96: Ultimate method resolution challenge
 * 
 * Overload + Override + Inheritance
 * Complex method resolution
 * Çıktı ne olur?
 */
class OOP96A {
    void method(Object o) {
        System.out.println("A method(Object)");
    }
    
    void method(String s) {
        System.out.println("A method(String)");
    }
}

class OOP96B extends OOP96A {
    void method(Integer i) {
        System.out.println("B method(Integer)");
    }
    
    @Override
    void method(Object o) {
        System.out.println("B method(Object)");
    }
    
    // method(String) inherit edilir
}

class OOP96C extends OOP96B {
    void method(Double d) {
        System.out.println("C method(Double)");
    }
    
    @Override
    void method(String s) {
        System.out.println("C method(String)");
    }
    
    // method(Object), method(Integer) inherit edilir
}

public class OOP96 {
    public static void main(String[] args) {
        OOP96A obj1 = new OOP96A();
        OOP96A obj2 = new OOP96B();
        OOP96A obj3 = new OOP96C();
        OOP96B obj4 = new OOP96C();
        OOP96C obj5 = new OOP96C();
        
        obj1.method("test");
        obj2.method("test"); // Trick!
        obj3.method("test"); // Trick!
        obj4.method("test"); // Trick!
        obj5.method("test");
        
        obj3.method(10);
        obj4.method(10);
        obj5.method(10);
    }
}

// ÇIKTI:
// A method(String)
// A method(String) (compile-time tip A, method(String) var)
// C method(String) (runtime tip C, override edilmiş)
// C method(String) (runtime tip C, override edilmiş)
// C method(String)
// B method(Integer) (compile-time tip A, method(Integer) yok, method(Object) var ama Integer daha spesifik değil)
// B method(Integer) (compile-time tip B, method(Integer) var)
// B method(Integer) (compile-time tip C, method(Integer) inherit edilmiş)
// Method resolution: Overload compile-time, override runtime




