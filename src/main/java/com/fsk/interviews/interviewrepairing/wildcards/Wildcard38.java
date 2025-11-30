package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 38: Wildcard ve bounded type parameter
 * 
 * Wildcard vs bounded type parameter
 * Hangi durumda hangisi kullanılır?
 * Çıktı ne olur?
 */
public class Wildcard38 {
    // Bounded type parameter - exact type bilinir
    public static <T extends Number> void method1(List<T> list) {
        T first = list.get(0);
        System.out.println("Method1: " + first);
        // list.add(first); // OK, exact type bilinir
    }
    
    // Wildcard - unknown type
    public static void method2(List<? extends Number> list) {
        Number first = list.get(0);
        System.out.println("Method2: " + first);
        // list.add(first); // HATA! Unknown type
    }
    
    // Bounded type parameter - return type
    public static <T extends Number> T getFirst(List<T> list) {
        return list.get(0);
    }
    
    // Wildcard - return type (genellikle kullanılmaz)
    public static Number getFirst2(List<? extends Number> list) {
        return list.get(0);
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        
        method1(list);
        method2(list);
        
        Integer first = getFirst(list);
        Number first2 = getFirst2(list);
        System.out.println("First: " + first + ", First2: " + first2);
    }
}

// ÇIKTI:
// Method1: 10
// Method2: 10
// First: 10, First2: 10
// Bounded type parameter exact type bilir, wildcard bilmez
// Type parameter write işlemleri yapabilir, wildcard yapamaz


