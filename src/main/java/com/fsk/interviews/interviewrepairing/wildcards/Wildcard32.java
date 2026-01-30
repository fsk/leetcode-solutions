package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 32: PECS Principle - Consumer Super
 * 
 * Consumer: Veri tüketen (write işlemleri)
 * ? super T kullanılır
 * Çıktı ne olur?
 */
public class Wildcard32 {
    // Consumer - super kullan
    public static void addNumbers(List<? super Integer> list) {
        list.add(10); // Write işlemi
        list.add(20);
        list.add(30);
    }
    
    // Consumer - super kullan
    public static void copy(List<? super Integer> dest, List<? extends Integer> src) {
        for (Integer num : src) { // Read from src
            dest.add(num); // Write to dest
        }
    }
    
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList);
        System.out.println("Number list: " + numberList);
        
        List<Integer> source = new ArrayList<>();
        source.add(1);
        source.add(2);
        
        List<Number> dest = new ArrayList<>();
        copy(dest, source);
        System.out.println("Copied: " + dest);
    }
}

// ÇIKTI:
// Number list: [10, 20, 30]
// Copied: [1, 2]
// PECS: Consumer Super - Veri tüketen metodlarda ? super T kullan




