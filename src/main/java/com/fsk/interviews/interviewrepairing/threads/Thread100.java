package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 100: CompletableFuture complex chain
 * 
 * Karmaşık bir CompletableFuture chain'i örneği.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread100 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        CompletableFuture<String> result = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("Step 1: Fetching data");
                return "Data";
            }, executor)
            .thenApplyAsync(data -> {
                System.out.println("Step 2: Processing " + data);
                return data + " Processed";
            }, executor)
            .thenComposeAsync(processed -> {
                System.out.println("Step 3: Saving " + processed);
                return CompletableFuture.supplyAsync(() -> {
                    return processed + " Saved";
                }, executor);
            }, executor)
            .thenCombineAsync(
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Step 4: Parallel task");
                    return "Parallel";
                }, executor),
                (saved, parallel) -> {
                    System.out.println("Step 5: Combining " + saved + " + " + parallel);
                    return saved + " " + parallel;
                },
                executor
            )
            .exceptionally(ex -> {
                System.out.println("Error: " + ex.getMessage());
                return "Error recovered";
            });
        
        System.out.println("Final result: " + result.join());
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Step 1: Fetching data
// Step 2: Processing Data
// Step 4: Parallel task (paralel çalışır)
// Step 3: Saving Data Processed
// Step 5: Combining Data Processed Saved + Parallel
// Final result: Data Processed Saved Parallel
// Karmaşık chain'lerde farklı thread'ler kullanılır

