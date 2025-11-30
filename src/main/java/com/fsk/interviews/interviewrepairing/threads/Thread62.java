package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 62: CompletableFuture thenCompose (flatMap)
 * 
 * thenCompose ile nested CompletableFuture'leri düzleştirebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread62 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> {
                System.out.println("İlk task: 10");
                return 10;
            })
            .thenCompose(num -> {
                System.out.println("İkinci task: " + num + " * 2");
                return CompletableFuture.supplyAsync(() -> num * 2);
            })
            .thenCompose(num -> {
                System.out.println("Üçüncü task: " + num + " + 5");
                return CompletableFuture.supplyAsync(() -> String.valueOf(num + 5));
            });
        
        String result = future.join();
        System.out.println("Sonuç: " + result);
    }
}

// ÇIKTI:
// İlk task: 10
// İkinci task: 10 * 2
// Üçüncü task: 20 + 5
// Sonuç: 25
// thenCompose nested future'leri düzleştirir


