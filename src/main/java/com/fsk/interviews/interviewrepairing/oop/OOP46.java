package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 46: Varargs ve method overloading ambiguity
 * 
 * Varargs metodlar overloading'de nasıl çalışır?
 * Ambiguity nasıl oluşur?
 * Çıktı ne olur?
 */
class OOP46Test {
    void method(int... args) {
        System.out.println("Varargs method");
    }
    
    void method(int a, int b) {
        System.out.println("Two ints method");
    }
    
    void method2(int a, int... args) {
        System.out.println("One int + varargs");
    }
    
    // void method2(int... args) { } // HATA! Ambiguous with method2(int, int...)
}

public class OOP46 {
    public static void main(String[] args) {
        OOP46Test test = new OOP46Test();
        test.method(1);
        test.method(1, 2);
        test.method(1, 2, 3);
        
        test.method2(1);
        test.method2(1, 2);
    }
}

// ÇIKTI:
// Varargs method
// Two ints method (en spesifik)
// Varargs method
// One int + varargs
// One int + varargs
// Varargs en son tercih edilir, exact match varsa o kullanılır


