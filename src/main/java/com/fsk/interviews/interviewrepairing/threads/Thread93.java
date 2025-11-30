package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 93: CompletableFuture runAfterBoth ve runAfterEither
 * 
 * runAfterBoth: İkisi de bitince çalışır
 * runAfterEither: Herhangi biri bitince çalışır
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread93 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 1";
        });
        
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 2";
        });
        
        // runAfterEither: İlk biten
        future1.runAfterEither(future2, () -> {
            System.out.println("Either completed");
        });
        
        // runAfterBoth: İkisi de bitince
        future1.runAfterBoth(future2, () -> {
            System.out.println("Both completed");
        });
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Either completed (1 saniye sonra - Task 2)
// Both completed (2 saniye sonra - Task 1)
// runAfterEither daha hızlı, runAfterBoth daha yavaş


