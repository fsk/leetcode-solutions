package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 42: Wildcard ve method reference
 * 
 * Method reference ile wildcard kullanımı
 * Çıktı ne olur?
 */
import java.util.function.Function;

public class Wildcard42 {
    // Wildcard parameter with method reference
    public static <T> void process(List<? extends T> list, Function<? super T, ?> mapper) {
        for (T item : list) {
            Object result = mapper.apply(item);
            System.out.println("Mapped: " + result);
        }
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        
        // Method reference
        process(ints, Object::toString);
        process(ints, i -> i * 2);
    }
}

// ÇIKTI:
// Mapped: 10
// Mapped: 20
// Mapped: 20
// Mapped: 40
// Wildcard ile method reference kullanılabilir
// Function<? super T, ?> consumer super pattern


