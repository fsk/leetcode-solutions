package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 50: Ultimate wildcard challenge
 * 
 * Tüm wildcard konseptlerini birleştiren ultimate challenge
 * PECS + Capture + Nested + Functional Interface
 * Çıktı ne olur?
 */
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Wildcard50 {
    // Ultimate method - tüm konseptleri birleştirir
    public static <T, R> List<R> ultimateProcess(
            List<? extends T> source,                    // Producer Extends
            Predicate<? super T> filter,                 // Consumer Super
            Function<? super T, ? extends R> mapper,    // Consumer Super, Producer Extends
            List<? super R> destination) {              // Consumer Super
        
        // Filter and map
        List<R> result = source.stream()
            .filter(filter)
            .map(mapper)
            .collect(Collectors.toList());
        
        // Copy to destination
        for (R item : result) {
            destination.add(item);
        }
        
        return result;
    }
    
    // Wildcard capture helper
    public static <T> void swap(List<? extends T> list, int i, int j) {
        swapHelper(list, i, j);
    }
    
    private static <T> void swapHelper(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>();
        source.add(5);
        source.add(15);
        source.add(25);
        source.add(35);
        
        List<Object> destination = new ArrayList<>();
        
        List<String> result = ultimateProcess(
            source,                           // Producer Extends
            n -> n > 10,                      // Predicate<? super Integer>
            n -> "Value: " + n,               // Function<? super Integer, ? extends String>
            destination                       // Consumer Super (Object super String)
        );
        
        System.out.println("Result: " + result);
        System.out.println("Destination: " + destination);
    }
}

// ÇIKTI:
// Result: [Value: 15, Value: 25, Value: 35]
// Destination: [Value: 15, Value: 25, Value: 35]
// Ultimate challenge: Tüm wildcard konseptleri bir arada!
// PECS + Capture + Functional Interface + Stream API

