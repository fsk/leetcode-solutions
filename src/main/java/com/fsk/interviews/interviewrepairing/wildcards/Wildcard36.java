package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 36: Wildcard ve method overloading
 * 
 * Wildcard ile method overloading nasıl çalışır?
 * Type erasure etkisi
 * Çıktı ne olur?
 */
public class Wildcard36 {
    // Bu iki metod aynı signature'a sahip (type erasure)
    // public static void method(List<? extends Number> list) { }
    // public static void method(List<? super Number> list) { } // HATA! Same signature
    
    // Farklı metodlar
    public static void method1(List<? extends Number> list) {
        System.out.println("method1 - extends");
    }
    
    public static void method2(List<? super Number> list) {
        System.out.println("method2 - super");
    }
    
    // Unbounded wildcard
    public static void method3(List<?> list) {
        System.out.println("method3 - unbounded");
    }
    
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        method1(intList);
        // method2(intList); // HATA! Integer super Number değil
        
        List<Number> numberList = new ArrayList<>();
        method1(numberList);
        method2(numberList);
        method3(numberList);
    }
}

// ÇIKTI:
// method1 - extends
// method1 - extends
// method2 - super
// method3 - unbounded
// Wildcard ile method overloading yapılabilir
// Type erasure nedeniyle ? extends ve ? super aynı signature'a sahip


