package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 18: Upper bounded wildcard ve generic method
 * 
 * Generic method ile upper bounded wildcard kombinasyonu
 * Çıktı ne olur?
 */
public class Wildcard18 {
    // Generic method with wildcard parameter
    public static <T extends Number> void process1(List<T> list) {
        // T exact type bilinir, write yapılabilir
        T first = list.get(0);
        System.out.println("First: " + first);
        // list.add(first); // OK, exact type bilinir
    }
    
    // Wildcard parameter
    public static void process2(List<? extends Number> list) {
        // ? unknown type, write yapılamaz
        Number first = list.get(0);
        System.out.println("First: " + first);
        // list.add(first); // HATA!
    }
    
    // Generic method returning wildcard
    public static <T extends Number> List<? extends T> getSubList(List<T> list, int size) {
        return list.subList(0, Math.min(size, list.size()));
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        
        process1(ints);
        process2(ints);
        
        List<? extends Integer> sublist = getSubList(ints, 1);
        System.out.println("Sublist: " + sublist);
    }
}

// ÇIKTI:
// First: 10
// First: 10
// Sublist: [10]
// Generic method ile wildcard kombinasyonu mümkün
// Generic method exact type bilir, wildcard bilmez




