package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 78: Parallel stream reduce operation
 * 
 * Parallel stream'de reduce işlemi dikkatli kullanılmalıdır.
 * Çıktı ne olur?
 */
import java.util.Arrays;
import java.util.List;

public class Thread78 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Sequential reduce
        int sequential = numbers.stream()
            .reduce(0, (a, b) -> {
                System.out.println("Sequential: " + a + " + " + b);
                return a + b;
            });
        System.out.println("Sequential sum: " + sequential);
        
        System.out.println("---");
        
        // Parallel reduce (associative olmalı)
        int parallel = numbers.parallelStream()
            .reduce(0, (a, b) -> {
                System.out.println("Parallel: " + a + " + " + b + " (" + 
                    Thread.currentThread().getName() + ")");
                return a + b;
            });
        System.out.println("Parallel sum: " + parallel);
        
        // Identity value önemli
        int wrong = numbers.parallelStream()
            .reduce(1, (a, b) -> a + b); // Yanlış! Identity 0 olmalı
        System.out.println("Wrong sum: " + wrong); // 56 (10 fazla)
    }
}

// ÇIKTI:
// Sequential: sırayla toplama
// Parallel: paralel toplama, farklı thread'ler
// Her ikisi de 55 sonucunu verir (doğru)
// Wrong sum: 56 (identity yanlış)


