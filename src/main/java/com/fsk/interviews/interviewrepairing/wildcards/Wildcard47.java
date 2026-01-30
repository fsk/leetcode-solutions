package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 47: Wildcard ve comparator
 * 
 * Comparator ile wildcard kullanımı
 * PECS pattern
 * Çıktı ne olur?
 */
import java.util.Comparator;
import java.util.Collections;

public class Wildcard47 {
    // Comparator<? super T> - Consumer Super
    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        Collections.sort(list, comparator);
    }
    
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(30);
        ints.add(10);
        ints.add(20);
        
        // Comparator<Integer> - exact type
        Comparator<Integer> intComparator = Integer::compare;
        sort(ints, intComparator);
        System.out.println("Sorted: " + ints);
        
        // Comparator<Number> - super type
        Comparator<Number> numberComparator = (a, b) -> 
            Double.compare(a.doubleValue(), b.doubleValue());
        sort(ints, numberComparator);
        System.out.println("Sorted with Number comparator: " + ints);
    }
}

// ÇIKTI:
// Sorted: [10, 20, 30]
// Sorted with Number comparator: [10, 20, 30]
// Comparator<? super T> kullanılır - Consumer Super
// T veya T'nin super type'ları kabul edilir




