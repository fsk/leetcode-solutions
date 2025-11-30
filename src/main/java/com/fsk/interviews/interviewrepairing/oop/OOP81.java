package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 81: Null ve method overloading extreme case
 * 
 * Null ile method overloading'de en zor senaryolar
 * Multiple inheritance simulation
 * Çıktı ne olur?
 */
class OOP81A {
    void method(Object o) {
        System.out.println("A method(Object)");
    }
}

class OOP81B extends OOP81A {
    void method(String s) {
        System.out.println("B method(String)");
    }
    
    void method(Integer i) {
        System.out.println("B method(Integer)");
    }
}

public class OOP81 {
    public static void main(String[] args) {
        OOP81A obj1 = new OOP81A();
        OOP81A obj2 = new OOP81B();
        OOP81B obj3 = new OOP81B();
        
        // obj1.method(null); // method(Object) çağrılır
        // obj2.method(null); // method(Object) çağrılır (compile-time tip)
        // obj3.method(null); // Ambiguous! String ve Integer eşit seviyede
        
        obj1.method((String) null);
        obj2.method((String) null);
        obj3.method((String) null);
    }
}

// ÇIKTI:
// A method(Object)
// A method(Object) (compile-time tip önemli)
// B method(String)
// Overload resolution compile-time'da yapılır, null için en spesifik tip seçilir


