package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 95: CompletableFuture thenComposeAsync
 * 
 * thenComposeAsync ile nested future'leri farklı thread'de işleyebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread95 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("Supply: " + Thread.currentThread().getName());
                return 10;
            }, executor)
            .thenComposeAsync(num -> {
                System.out.println("Compose: " + Thread.currentThread().getName());
                return CompletableFuture.supplyAsync(() -> {
                    System.out.println("Nested: " + Thread.currentThread().getName());
                    return String.valueOf(num * 2);
                }, executor);
            }, executor);
        
        String result = future.join();
        System.out.println("Result: " + result);
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Supply: pool-1-thread-1
// Compose: pool-1-thread-2 (farklı thread)
// Nested: pool-1-thread-2
// Result: 20
// thenComposeAsync farklı thread'de çalışır




