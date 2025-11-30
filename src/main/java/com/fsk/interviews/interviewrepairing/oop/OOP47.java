package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 47: Static nested class ve generic trick
 * 
 * Static nested class generic olabilir mi?
 * Outer class generic ise nested class nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP47Outer<T> {
    private T value;
    
    static class StaticNested<U> {
        U nestedValue;
        
        void method() {
            System.out.println("Static nested: " + nestedValue);
        }
    }
    
    class Inner {
        T innerValue;
        
        void method() {
            System.out.println("Inner: " + innerValue + ", Outer: " + value);
        }
    }
}

public class OOP47 {
    public static void main(String[] args) {
        OOP47Outer<String> outer = new OOP47Outer<>();
        
        OOP47Outer.StaticNested<Integer> nested = new OOP47Outer.StaticNested<>();
        nested.nestedValue = 100;
        nested.method();
        
        OOP47Outer<String>.Inner inner = outer.new Inner();
        inner.innerValue = "test";
        inner.method();
    }
}

// ÇIKTI:
// Static nested: 100
// Inner: test, Outer: null
// Static nested class kendi generic type'ına sahip olabilir
// Inner class outer class'ın generic type'ını kullanır


