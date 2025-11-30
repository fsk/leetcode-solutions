package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 67: CompletableFuture custom executor
 * 
 * CompletableFuture'e custom executor verebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread67 {
    public static void main(String[] args) {
        ExecutorService customExecutor = Executors.newFixedThreadPool(3);
        
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Default executor: " + Thread.currentThread().getName());
            return "Default";
        });
        
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Custom executor: " + Thread.currentThread().getName());
            return "Custom";
        }, customExecutor);
        
        System.out.println("Future1: " + future1.join());
        System.out.println("Future2: " + future2.join());
        
        customExecutor.shutdown();
    }
}

// ÇIKTI:
// Default executor: ForkJoinPool.commonPool-worker-1
// Custom executor: pool-1-thread-1
// Future1: Default
// Future2: Custom
// Custom executor ile thread pool kontrolü yapabiliriz


