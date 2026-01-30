package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 27: Lower bounded wildcard ve nested collections
 * 
 * List<? super List<? super Integer>> gibi nested lower bounded
 * Çıktı ne olur?
 */
public class Wildcard27 {
    // Nested lower bounded - daha basit örnek
    public static void processNested(List<? super List<? super Integer>> nested) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        
        // Write işlemi - List<Integer> eklenebilir (List<Integer> is List<? super Integer>)
        nested.add(intList);
        
        // Read işlemi - sadece Object olarak
        if (!nested.isEmpty()) {
            Object first = nested.get(0);
            if (first instanceof List) {
                @SuppressWarnings("unchecked")
                List<? super Integer> list = (List<? super Integer>) first;
                System.out.println("Nested list size: " + list.size());
            }
        }
    }
    
    public static void main(String[] args) {
        // List<List<? super Integer>> kullan
        List<List<? super Integer>> wildcardLists = new ArrayList<>();
        processNested(wildcardLists);
        System.out.println("Result: " + wildcardLists);
    }
}

// ÇIKTI:
// Nested list size: 2
// Result: [[10, 20]]
// Nested list size: 2
// Result: [[10, 20]]
// Nested lower bounded wildcard kullanılabilir
// Write işlemleri yapılabilir, read işlemleri Object olarak

