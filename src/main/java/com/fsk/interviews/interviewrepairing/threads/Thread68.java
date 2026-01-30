package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 68: CompletableFuture getNow ve complete
 * 
 * getNow: Hemen döner, bitmemişse varsayılan değer döner
 * complete: Manuel olarak tamamlayabiliriz
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread68 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Async result";
        });
        
        // getNow: Bitmemişse varsayılan değer döner
        String immediate = future.getNow("Default value");
        System.out.println("getNow: " + immediate);
        
        // complete: Manuel tamamlama
        CompletableFuture<String> future2 = new CompletableFuture<>();
        boolean completed = future2.complete("Manual completion");
        System.out.println("Complete başarılı: " + completed);
        System.out.println("Future2: " + future2.join());
        
        // completeExceptionally: Exception ile tamamla
        CompletableFuture<String> future3 = new CompletableFuture<>();
        future3.completeExceptionally(new RuntimeException("Manual exception"));
        
        try {
            future3.join();
        } catch (Exception e) {
            System.out.println("Exception yakalandı: " + e.getCause().getMessage());
        }
    }
}

// ÇIKTI:
// getNow: Default value (future henüz bitmemiş)
// Complete başarılı: true
// Future2: Manual completion
// Exception yakalandı: Manual exception




