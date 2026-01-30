package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 16: Upper bounded wildcard ve method chaining
 * 
 * ? extends T ile method chaining yapılabilir mi?
 * Çıktı ne olur?
 */
public class Wildcard16 {
    public static List<? extends Number> getNumbers() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        return list;
    }
    
    public static void process(List<? extends Number> list) {
        // Method chaining - read operations
        System.out.println("Size: " + list.size());
        System.out.println("First: " + (list.isEmpty() ? null : list.get(0)));
        
        // Chaining with sublist
        if (list.size() > 1) {
            List<? extends Number> sublist = list.subList(0, Math.min(2, list.size()));
            System.out.println("Sublist size: " + sublist.size());
        }
        
        // list.add(10).add(20); // HATA! add() yapılamaz
    }
    
    public static void main(String[] args) {
        List<? extends Number> numbers = getNumbers();
        process(numbers);
    }
}

// ÇIKTI:
// Size: 2
// First: 1
// Sublist size: 2
// Upper bounded wildcard ile read-only method chaining yapılabilir
// Write operations chain'lenemez




