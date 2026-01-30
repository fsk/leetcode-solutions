package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 92: CompletableFuture thenAcceptBoth
 * 
 * thenAcceptBoth ile iki future'in sonuçlarını birlikte işleyebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread92 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "World";
        });
        
        CompletableFuture<Void> combined = future1.thenAcceptBoth(future2, (s1, s2) -> {
            System.out.println("Combined: " + s1 + " " + s2);
        });
        
        combined.join();
        System.out.println("İşlem tamamlandı");
    }
}

// ÇIKTI:
// Combined: Hello World
// İşlem tamamlandı
// İki future'in sonuçlarını birlikte işler, ikisi de bitene kadar bekler




