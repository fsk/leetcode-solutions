package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 61: CompletableFuture supplyAsync ve thenApply
 * 
 * CompletableFuture ile asenkron işlemler yapabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread61 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("Async task başladı: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello";
            })
            .thenApply(s -> {
                System.out.println("thenApply çalıştı: " + Thread.currentThread().getName());
                return s + " World";
            })
            .thenApply(s -> {
                System.out.println("İkinci thenApply: " + Thread.currentThread().getName());
                return s + "!";
            });
        
        System.out.println("Main thread devam ediyor");
        
        String result = future.join(); // Blocking
        System.out.println("Sonuç: " + result);
    }
}

// ÇIKTI:
// Main thread devam ediyor
// Async task başladı: ForkJoinPool.commonPool-worker-1
// thenApply çalıştı: ForkJoinPool.commonPool-worker-1
// İkinci thenApply: ForkJoinPool.commonPool-worker-1
// Sonuç: Hello World!




