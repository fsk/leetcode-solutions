package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 66: CompletableFuture thenAccept ve thenRun
 * 
 * thenAccept: Sonucu alır ama döndürmez
 * thenRun: Sonuç almaz, sadece çalıştırır
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread66 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task çalışıyor");
            return "Hello";
        });
        
        // thenAccept: Sonucu alır, işler, döndürmez
        CompletableFuture<Void> acceptFuture = future.thenAccept(s -> {
            System.out.println("thenAccept: " + s);
        });
        
        // thenRun: Sonuç almaz, sadece çalıştırır
        CompletableFuture<Void> runFuture = future.thenRun(() -> {
            System.out.println("thenRun çalıştı");
        });
        
        acceptFuture.join();
        runFuture.join();
        
        System.out.println("Tüm işlemler tamamlandı");
    }
}

// ÇIKTI:
// Task çalışıyor
// thenAccept: Hello
// thenRun çalıştı
// Tüm işlemler tamamlandı
// thenAccept sonucu alır, thenRun almaz


