package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 17: Method overloading ve autoboxing/unboxing
 * 
 * Primitive ve wrapper type arasında overloading nasıl çalışır?
 * Autoboxing/unboxing nasıl etkiler?
 * Çıktı ne olur?
 */
class OOP17Test {
    void method(int x) {
        System.out.println("method(int): " + x);
    }
    
    void method(Integer x) {
        System.out.println("method(Integer): " + x);
    }
    
    void method2(int x) {
        System.out.println("method2(int): " + x);
    }
}

public class OOP17 {
    public static void main(String[] args) {
        OOP17Test test = new OOP17Test();
        test.method(10); // Hangi metod?
        test.method(new Integer(10)); // Hangi metod?
        
        // method2 sadece int var
        test.method2(10); // Autoboxing yok, direkt int
        // test.method2(new Integer(10)); // Autoboxing yok, compile error
    }
}

// ÇIKTI:
// method(int): 10 (en spesifik - primitive)
// method(Integer): 10 (en spesifik - wrapper)
// method2(int): 10
// Autoboxing/unboxing sadece gerekli olduğunda yapılır, exact match varsa o kullanılır

