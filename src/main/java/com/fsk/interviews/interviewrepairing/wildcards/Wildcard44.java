package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 44: Wildcard ve type inference
 * 
 * Type inference wildcard'ı nasıl etkiler?
 * Çıktı ne olur?
 */
public class Wildcard44 {
    public static <T> void method1(List<T> list) {
        System.out.println("Method1: " + list);
    }
    
    public static void method2(List<?> list) {
        System.out.println("Method2: " + list);
    }
    
    public static <T extends Number> void method3(List<? extends T> list) {
        System.out.println("Method3: " + list);
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        
        // Type inference
        method1(ints); // T = Integer
        method2(ints); // ? = ?
        method3(ints); // T = Integer, ? extends Integer
        
        // Explicit type
        Wildcard44.<Integer>method1(ints);
        // Wildcard44.<?>method2(ints); // HATA! Wildcard explicit olamaz
    }
}

// ÇIKTI:
// Method1: [10]
// Method2: [10]
// Method3: [10]
// Method1: [10]
// Type inference wildcard ile çalışır
// Wildcard explicit type argument olamaz


