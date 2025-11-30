package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 74: ForkJoinPool custom pool size
 * 
 * ForkJoinPool'un thread sayısını özelleştirebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Thread74 {
    public static void main(String[] args) {
        // Default ForkJoinPool
        System.out.println("Default parallelism: " + 
            ForkJoinPool.commonPool().getParallelism());
        
        // Custom ForkJoinPool
        ForkJoinPool customPool = new ForkJoinPool(4);
        System.out.println("Custom parallelism: " + customPool.getParallelism());
        
        customPool.submit(() -> {
            IntStream.range(0, 10)
                .parallel()
                .forEach(i -> {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                });
        }).join();
        
        customPool.shutdown();
    }
}

// ÇIKTI:
// Default parallelism: (CPU core sayısı - 1)
// Custom parallelism: 4
// Custom pool'da 4 thread çalışır
// Parallel stream custom pool'u kullanır


