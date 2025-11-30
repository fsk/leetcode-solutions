package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 63: CompletableFuture thenCombine
 * 
 * thenCombine ile iki CompletableFuture'i birleştirebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread63 {
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
        
        CompletableFuture<String> combined = future1.thenCombine(future2, (s1, s2) -> {
            System.out.println("Birleştiriliyor: " + s1 + " + " + s2);
            return s1 + " " + s2;
        });
        
        String result = combined.join();
        System.out.println("Sonuç: " + result);
    }
}

// ÇIKTI:
// Birleştiriliyor: Hello + World
// Sonuç: Hello World
// İki future paralel çalışır, ikisi de bitince birleştirilir


