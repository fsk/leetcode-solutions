package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 72: Parallel Stream kullanımı
 * 
 * Parallel stream ile collection'ları paralel işleyebiliriz.
 * Çıktı ne olur?
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Thread72 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Sequential stream
        List<Integer> sequential = numbers.stream()
            .map(n -> {
                System.out.println("Sequential: " + Thread.currentThread().getName() + " - " + n);
                return n * 2;
            })
            .collect(Collectors.toList());
        
        System.out.println("---");
        
        // Parallel stream
        List<Integer> parallel = numbers.parallelStream()
            .map(n -> {
                System.out.println("Parallel: " + Thread.currentThread().getName() + " - " + n);
                return n * 2;
            })
            .collect(Collectors.toList());
        
        System.out.println("Sequential: " + sequential);
        System.out.println("Parallel: " + parallel);
    }
}

// ÇIKTI:
// Sequential: main - 1, 2, 3, ... (sırayla)
// Parallel: ForkJoinPool.commonPool-worker-X - (karışık sırada)
// Parallel stream ForkJoinPool kullanır




