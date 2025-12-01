package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 94: CompletableFuture orTimeout
 * 
 * orTimeout ile future'e timeout ekleyebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Thread94 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Success";
            })
            .orTimeout(2, TimeUnit.SECONDS)
            .exceptionally(ex -> {
                if (ex.getCause() instanceof TimeoutException) {
                    return "Timeout occurred";
                }
                return "Other error";
            });
        
        String result = future.join();
        System.out.println("Result: " + result);
    }
}

// ÇIKTI:
// Result: Timeout occurred
// 2 saniye sonra timeout olur, TimeoutException fırlatılır
// exceptionally ile handle edilir




