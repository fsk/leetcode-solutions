package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 34: Interface private method
 * 
 * Java 9+ ile interface'de private metodlar olabilir.
 * Bunlar ne için kullanılır?
 * Çıktı ne olur?
 */
interface OOP34A {
    default void method1() {
        System.out.println("method1()");
        helperMethod(); // Private metod çağrılır
    }
    
    default void method2() {
        System.out.println("method2()");
        helperMethod(); // Private metod çağrılır
    }
    
    private void helperMethod() {
        System.out.println("Private helper method");
    }
    
    private static void staticHelper() {
        System.out.println("Private static helper");
    }
    
    static void staticMethod() {
        staticHelper(); // Private static metod çağrılır
    }
}

class OOP34B implements OOP34A {
    // Private metodlara erişim yok
}

public class OOP34 {
    public static void main(String[] args) {
        OOP34B obj = new OOP34B();
        obj.method1();
        obj.method2();
        OOP34A.staticMethod();
    }
}

// ÇIKTI:
// method1()
// Private helper method
// method2()
// Private helper method
// Private static helper
// Private metodlar interface içinde code reuse için kullanılır




