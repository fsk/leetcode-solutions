package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 97: CompletableFuture thenCombineAsync
 * 
 * thenCombineAsync ile iki future'i farklı thread'de birleştirebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread97 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future1: " + Thread.currentThread().getName());
            return 10;
        }, executor);
        
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future2: " + Thread.currentThread().getName());
            return 20;
        }, executor);
        
        CompletableFuture<Integer> combined = future1.thenCombineAsync(future2, (a, b) -> {
            System.out.println("Combine: " + Thread.currentThread().getName());
            return a + b;
        }, executor);
        
        System.out.println("Result: " + combined.join());
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Future1: pool-1-thread-1
// Future2: pool-1-thread-2
// Combine: pool-1-thread-3 (farklı thread)
// Result: 30
// thenCombineAsync birleştirme işlemini farklı thread'de yapar




