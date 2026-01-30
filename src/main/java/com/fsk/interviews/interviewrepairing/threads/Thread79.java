package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 79: ForkJoinPool parallelism level
 * 
 * ForkJoinPool'un parallelism seviyesini kontrol edebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Thread79 {
    public static void main(String[] args) {
        System.out.println("CPU cores: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Default parallelism: " + 
            ForkJoinPool.commonPool().getParallelism());
        
        // Custom parallelism
        ForkJoinPool pool1 = new ForkJoinPool(2);
        System.out.println("Pool1 parallelism: " + pool1.getParallelism());
        
        ForkJoinPool pool2 = new ForkJoinPool(8);
        System.out.println("Pool2 parallelism: " + pool2.getParallelism());
        
        // Parallel stream custom pool'da çalıştır
        pool1.submit(() -> {
            IntStream.range(0, 10)
                .parallel()
                .forEach(i -> {
                    System.out.println("Pool1: " + Thread.currentThread().getName() + " - " + i);
                });
        }).join();
        
        pool1.shutdown();
        pool2.shutdown();
    }
}

// ÇIKTI:
// CPU cores: (sistem CPU sayısı)
// Default parallelism: (CPU cores - 1)
// Pool1 parallelism: 2
// Pool2 parallelism: 8
// Parallel stream custom pool'un parallelism'ini kullanır




