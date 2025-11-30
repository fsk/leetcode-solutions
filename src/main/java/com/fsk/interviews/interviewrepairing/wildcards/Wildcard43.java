package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 43: Wildcard ve stream operations
 * 
 * Stream API ile wildcard kullanımı
 * Çıktı ne olur?
 */
import java.util.stream.Collectors;

public class Wildcard43 {
    public static void processStream(List<? extends Number> numbers) {
        // Stream operations
        List<Double> doubles = numbers.stream()
            .map(Number::doubleValue)
            .collect(Collectors.toList());
        System.out.println("Doubles: " + doubles);
        
        double sum = numbers.stream()
            .mapToDouble(Number::doubleValue)
            .sum();
        System.out.println("Sum: " + sum);
        
        // Filter
        List<? extends Number> filtered = numbers.stream()
            .filter(n -> n.doubleValue() > 10)
            .collect(Collectors.toList());
        System.out.println("Filtered: " + filtered);
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(5);
        ints.add(15);
        ints.add(25);
        processStream(ints);
    }
}

// ÇIKTI:
// Doubles: [5.0, 15.0, 25.0]
// Sum: 45.0
// Filtered: [15, 25]
// Stream API wildcard ile kullanılabilir
// Method reference ve lambda expressions çalışır


