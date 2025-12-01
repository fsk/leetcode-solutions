package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 34: PECS ve method combination
 * 
 * Hem producer hem consumer olan metod
 * Çıktı ne olur?
 */
public class Wildcard34 {
    // Hem producer hem consumer
    public static <T> void transfer(
            List<? extends T> source,  // Producer
            List<? super T> dest) {    // Consumer
        for (T item : source) {
            dest.add(item);
        }
    }
    
    // Sadece producer
    public static <T> T getFirst(List<? extends T> list) {
        return list.isEmpty() ? null : list.get(0);
    }
    
    // Sadece consumer
    public static <T> void addFirst(List<? super T> list, T item) {
        list.add(0, item);
    }
    
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>();
        source.add(10);
        source.add(20);
        
        List<Number> dest = new ArrayList<>();
        transfer(source, dest);
        System.out.println("Transferred: " + dest);
        
        Integer first = getFirst(source);
        System.out.println("First: " + first);
        
        addFirst(dest, 30);
        System.out.println("After addFirst: " + dest);
    }
}

// ÇIKTI:
// Transferred: [10, 20]
// First: 10
// After addFirst: [30, 10, 20]
// PECS: Producer Extends, Consumer Super
// Hem producer hem consumer olan metodlarda her ikisi de kullanılır




