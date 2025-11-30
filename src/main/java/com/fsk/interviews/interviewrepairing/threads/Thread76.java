package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 76: Parallel stream ordered vs unordered
 * 
 * Ordered stream sırayı korur, unordered daha hızlı olabilir.
 * Çıktı ne olur?
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Thread76 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Ordered (sırayı korur)
        List<Integer> ordered = numbers.parallelStream()
            .map(n -> {
                System.out.println("Ordered: " + n);
                return n * 2;
            })
            .collect(Collectors.toList());
        
        System.out.println("Ordered result: " + ordered);
        
        // Unordered (daha hızlı olabilir)
        List<Integer> unordered = numbers.parallelStream()
            .unordered()
            .map(n -> {
                System.out.println("Unordered: " + n);
                return n * 2;
            })
            .collect(Collectors.toList());
        
        System.out.println("Unordered result: " + unordered);
    }
}

// ÇIKTI:
// Ordered: sayılar karışık sırada işlenir ama sonuç sıralı
// Unordered: sayılar karışık sırada işlenir, sonuç da karışık olabilir
// Unordered daha performanslı olabilir (sıra korunması gerekmiyorsa)


