package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 80: Parallel stream performance considerations
 * 
 * Parallel stream her zaman daha hızlı değildir.
 * Overhead ve data size önemlidir.
 * Çıktı ne olur?
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Thread80 {
    public static void main(String[] args) {
        // Küçük data set
        List<Integer> small = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            small.add(i);
        }
        
        long start1 = System.currentTimeMillis();
        small.stream().map(n -> n * 2).collect(Collectors.toList());
        long sequential1 = System.currentTimeMillis() - start1;
        
        long start2 = System.currentTimeMillis();
        small.parallelStream().map(n -> n * 2).collect(Collectors.toList());
        long parallel1 = System.currentTimeMillis() - start2;
        
        System.out.println("Small dataset - Sequential: " + sequential1 + "ms");
        System.out.println("Small dataset - Parallel: " + parallel1 + "ms");
        
        // Büyük data set
        List<Integer> large = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            large.add(i);
        }
        
        long start3 = System.currentTimeMillis();
        large.stream().map(n -> n * 2).collect(Collectors.toList());
        long sequential2 = System.currentTimeMillis() - start3;
        
        long start4 = System.currentTimeMillis();
        large.parallelStream().map(n -> n * 2).collect(Collectors.toList());
        long parallel2 = System.currentTimeMillis() - start4;
        
        System.out.println("Large dataset - Sequential: " + sequential2 + "ms");
        System.out.println("Large dataset - Parallel: " + parallel2 + "ms");
    }
}

// ÇIKTI:
// Küçük dataset'te sequential daha hızlı olabilir (overhead)
// Büyük dataset'te parallel daha hızlı olabilir
// Data size ve işlem karmaşıklığına bağlı




