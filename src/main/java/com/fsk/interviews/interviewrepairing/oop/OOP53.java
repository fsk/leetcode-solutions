package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 53: Null ve method overloading ambiguity
 * 
 * Null argümanı ile method overloading'de ambiguity nasıl çözülür?
 * Çıktı ne olur?
 */
class OOP53Test {
    void method(String s) {
        System.out.println("method(String)");
    }
    
    void method(Integer i) {
        System.out.println("method(Integer)");
    }
    
    void method(Object o) {
        System.out.println("method(Object)");
    }
    
    void method2(String s) {
        System.out.println("method2(String)");
    }
    
    void method2(Object o) {
        System.out.println("method2(Object)");
    }
}

public class OOP53 {
    public static void main(String[] args) {
        OOP53Test test = new OOP53Test();
        // test.method(null); // Ambiguous! String ve Integer eşit seviyede
        test.method((String) null); // Explicit cast
        test.method((Integer) null); // Explicit cast
        test.method2(null); // String daha spesifik, bu yüzden method2(String) çağrılır
    }
}

// ÇIKTI:
// method(String)
// method(Integer)
// method2(String)
// Null için en spesifik tip seçilir, eşit seviyede ise ambiguous


