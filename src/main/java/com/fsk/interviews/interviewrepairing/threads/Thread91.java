package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 91: CompletableFuture chain ve error propagation
 * 
 * CompletableFuture chain'inde error nasıl propagate edilir?
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread91 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("Step 1");
                return "Step1";
            })
            .thenApply(s -> {
                System.out.println("Step 2");
                throw new RuntimeException("Error in step 2");
            })
            .thenApply(s -> {
                System.out.println("Step 3 (bu çalışmaz)");
                return s + " Step3";
            })
            .exceptionally(ex -> {
                System.out.println("Exception handled: " + ex.getMessage());
                return "Error recovered";
            });
        
        System.out.println("Result: " + future.join());
    }
}

// ÇIKTI:
// Step 1
// Step 2
// Exception handled: java.lang.RuntimeException: Error in step 2
// Result: Error recovered
// Exception chain'i durdurur, exceptionally ile handle edilir




