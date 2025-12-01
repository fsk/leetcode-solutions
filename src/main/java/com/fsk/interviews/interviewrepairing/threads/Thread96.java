package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 96: CompletableFuture allOf ile result collection
 * 
 * allOf ile tüm future'lerin sonuçlarını toplayabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Thread96 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Result1");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Result2");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Result3");
        
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2, future3);
        
        CompletableFuture<String> combined = allOf.thenApply(v -> {
            return Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(", "));
        });
        
        System.out.println("Combined: " + combined.join());
    }
}

// ÇIKTI:
// Combined: Result1, Result2, Result3
// allOf tüm future'lerin bitmesini bekler, sonra sonuçları toplar




