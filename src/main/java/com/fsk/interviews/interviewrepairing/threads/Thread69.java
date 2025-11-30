package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 69: CompletableFuture whenComplete
 * 
 * whenComplete hem success hem error durumunda çalışır.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread69 {
    public static void main(String[] args) {
        // Success case
        CompletableFuture<String> future1 = CompletableFuture
            .supplyAsync(() -> "Success")
            .whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Success: " + result);
                } else {
                    System.out.println("Error: " + ex.getMessage());
                }
            });
        
        System.out.println("Future1: " + future1.join());
        
        // Error case
        CompletableFuture<String> future2 = CompletableFuture
            .<String>supplyAsync(() -> {
                throw new RuntimeException("Test error");
            })
            .whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Success: " + result);
                } else {
                    System.out.println("Error: " + ex.getMessage());
                }
            });
        
        try {
            future2.join();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getCause().getMessage());
        }
    }
}

// ÇIKTI:
// Success: Success
// Future1: Success
// Error: java.lang.RuntimeException: Test error
// Exception: java.lang.RuntimeException: Test error
// whenComplete her durumda çalışır, exception'ı propagate eder

