package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 98: CompletableFuture cancel ve isCancelled
 * 
 * CompletableFuture'i iptal edebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CancellationException;

public class Thread98 {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                future.complete("Success");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        thread.start();
        
        // 1 saniye sonra iptal et
        try {
            Thread.sleep(1000);
            boolean cancelled = future.cancel(true);
            System.out.println("Cancelled: " + cancelled);
            System.out.println("Is cancelled: " + future.isCancelled());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        try {
            String result = future.join();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            if (e.getCause() instanceof CancellationException) {
                System.out.println("Future cancelled");
            }
        }
    }
}

// ÇIKTI:
// Cancelled: true
// Is cancelled: true
// Future cancelled
// cancel() ile future'i iptal edebiliriz


