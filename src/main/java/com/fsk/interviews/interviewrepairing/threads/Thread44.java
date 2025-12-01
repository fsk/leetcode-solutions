package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 44: CompletableFuture kullanımı
 * 
 * CompletableFuture ile asenkron işlemler yapabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread44 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        
        CompletableFuture<String> result = future.thenApply(s -> s + " World")
                                                 .thenApply(s -> s + "!");
        
        result.thenAccept(System.out::println);
        
        System.out.println("Main thread devam ediyor");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Main thread devam ediyor
// Hello World!
// CompletableFuture chain'lenebilir ve asenkron çalışır




