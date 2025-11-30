package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 85: ExecutorService isShutdown vs isTerminated
 * 
 * isShutdown: Shutdown çağrıldı mı?
 * isTerminated: Tüm task'lar bitti mi?
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread85 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        executor.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        System.out.println("Shutdown öncesi - isShutdown: " + executor.isShutdown());
        System.out.println("Shutdown öncesi - isTerminated: " + executor.isTerminated());
        
        executor.shutdown();
        
        System.out.println("Shutdown sonrası - isShutdown: " + executor.isShutdown());
        System.out.println("Shutdown sonrası - isTerminated: " + executor.isTerminated());
        
        try {
            executor.awaitTermination(3, TimeUnit.SECONDS);
            System.out.println("Termination sonrası - isShutdown: " + executor.isShutdown());
            System.out.println("Termination sonrası - isTerminated: " + executor.isTerminated());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Shutdown öncesi - isShutdown: false, isTerminated: false
// Shutdown sonrası - isShutdown: true, isTerminated: false
// Termination sonrası - isShutdown: true, isTerminated: true


