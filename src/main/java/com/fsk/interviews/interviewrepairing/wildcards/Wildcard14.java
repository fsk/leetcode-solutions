package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 14: Upper bounded wildcard ve collection operations
 * 
 * ? extends T ile hangi collection işlemleri yapılabilir?
 * Çıktı ne olur?
 */
public class Wildcard14 {
    public static void operations(List<? extends Number> list) {
        // Read operations
        System.out.println("Size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
        
        if (!list.isEmpty()) {
            Number first = list.get(0);
            Number last = list.get(list.size() - 1);
            System.out.println("First: " + first);
            System.out.println("Last: " + last);
        }
        
        // Contains, indexOf
        System.out.println("Contains 10: " + list.contains(10));
        
        // Sublist
        if (list.size() > 1) {
            List<? extends Number> sublist = list.subList(0, 1);
            System.out.println("Sublist: " + sublist);
        }
        
        // toArray
        Object[] array = list.toArray();
        System.out.println("Array length: " + array.length);
        
        // list.add(10); // HATA!
        // list.remove(0); // HATA!
        // list.clear(); // HATA!
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        operations(list);
    }
}

// ÇIKTI:
// Size: 3
// Is empty: false
// First: 10
// Last: 30
// Contains 10: true
// Sublist: [10]
// Array length: 3
// Upper bounded wildcard ile read-only collection işlemleri yapılabilir
// Modifying operations yapılamaz


