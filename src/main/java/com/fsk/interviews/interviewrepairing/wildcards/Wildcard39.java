package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 39: Wildcard ve method chaining
 * 
 * Wildcard ile method chaining yapılabilir mi?
 * Çıktı ne olur?
 */
public class Wildcard39 {
    // Wildcard return - chaining zor
    public static List<? extends Number> getNumbers() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        return list;
    }
    
    // Type parameter return - chaining kolay
    public static <T extends Number> List<T> getNumbers2() {
        List<T> list = new ArrayList<>();
        return list;
    }
    
    // Method chaining with wildcard
    public static void process(List<? extends Number> list) {
        // Read operations chain
        System.out.println("Size: " + list.size());
        if (!list.isEmpty()) {
            System.out.println("First: " + list.get(0));
            System.out.println("Last: " + list.get(list.size() - 1));
        }
        
        // Sublist chain
        if (list.size() > 1) {
            List<? extends Number> sublist = list.subList(0, 1);
            System.out.println("Sublist size: " + sublist.size());
        }
    }
    
    public static void main(String[] args) {
        List<? extends Number> numbers = getNumbers();
        process(numbers);
        
        // Chaining zor
        // getNumbers().add(20); // HATA!
    }
}

// ÇIKTI:
// Size: 1
// First: 10
// Last: 10
// Sublist size: 1
// Wildcard ile read-only method chaining yapılabilir
// Write operations chain'lenemez




