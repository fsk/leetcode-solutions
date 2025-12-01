package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 70: CompletableFuture thenApplyAsync
 * 
 * thenApplyAsync ile sonraki adımı farklı thread'de çalıştırabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread70 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("Supply: " + Thread.currentThread().getName());
                return "Hello";
            }, executor)
            .thenApply(s -> {
                System.out.println("thenApply: " + Thread.currentThread().getName());
                return s + " World";
            })
            .thenApplyAsync(s -> {
                System.out.println("thenApplyAsync: " + Thread.currentThread().getName());
                return s + "!";
            }, executor);
        
        String result = future.join();
        System.out.println("Sonuç: " + result);
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Supply: pool-1-thread-1
// thenApply: pool-1-thread-1 (aynı thread)
// thenApplyAsync: pool-1-thread-2 (farklı thread)
// Sonuç: Hello World!
// thenApply aynı thread'de, thenApplyAsync farklı thread'de çalışır




