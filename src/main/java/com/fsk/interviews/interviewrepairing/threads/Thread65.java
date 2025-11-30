package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 65: CompletableFuture exception handling
 * 
 * CompletableFuture'de exception'ları handle edebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread65 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> {
                if (Math.random() > 0.5) {
                    throw new RuntimeException("Random exception");
                }
                return "Success";
            })
            .exceptionally(ex -> {
                System.out.println("Exception yakalandı: " + ex.getMessage());
                return "Error handled";
            })
            .thenApply(s -> {
                System.out.println("İşlem: " + s);
                return s.toUpperCase();
            });
        
        String result = future.join();
        System.out.println("Sonuç: " + result);
        
        // handle() ile hem success hem error
        CompletableFuture<String> future2 = CompletableFuture
            .supplyAsync(() -> {
                throw new RuntimeException("Test error");
            })
            .handle((result2, ex) -> {
                if (ex != null) {
                    return "Error: " + ex.getMessage();
                }
                return "Success: " + result2;
            });
        
        System.out.println("Handle sonucu: " + future2.join());
    }
}

// ÇIKTI:
// Exception yakalandı: Random exception (veya Success)
// İşlem: Error handled (veya Success)
// Sonuç: ERROR HANDLED (veya SUCCESS)
// Handle sonucu: Error: java.lang.RuntimeException: Test error


