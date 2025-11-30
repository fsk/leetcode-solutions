package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 33: Functional interface ve lambda
 * 
 * Functional interface nedir?
 * Lambda expression nasıl çalışır?
 * Çıktı ne olur?
 */
@FunctionalInterface
interface OOP33A {
    void method(String s);
    
    // void method2(); // HATA! Functional interface'de tek abstract metod olmalı
    default void defaultMethod() {
        System.out.println("Default method");
    }
    
    static void staticMethod() {
        System.out.println("Static method");
    }
}

public class OOP33 {
    public static void main(String[] args) {
        // Anonymous class
        OOP33A obj1 = new OOP33A() {
            @Override
            public void method(String s) {
                System.out.println("Anonymous: " + s);
            }
        };
        
        // Lambda expression
        OOP33A obj2 = s -> System.out.println("Lambda: " + s);
        
        // Method reference
        OOP33A obj3 = System.out::println;
        
        obj1.method("test1");
        obj2.method("test2");
        obj3.method("test3");
        
        obj1.defaultMethod();
        OOP33A.staticMethod();
    }
}

// ÇIKTI:
// Anonymous: test1
// Lambda: test2
// test3
// Default method
// Static method
// Functional interface tek abstract metod içerir, lambda ile kullanılabilir


