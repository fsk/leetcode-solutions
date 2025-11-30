package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 83: ExecutorService awaitTermination
 * 
 * awaitTermination ile executor'ın kapanmasını bekleyebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread83 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor.submit(() -> {
                try {
                    System.out.println("Task " + id + " çalışıyor");
                    Thread.sleep(1000);
                    System.out.println("Task " + id + " bitti");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor.shutdown();
        System.out.println("Shutdown çağrıldı");
        
        try {
            boolean terminated = executor.awaitTermination(3, TimeUnit.SECONDS);
            if (terminated) {
                System.out.println("Executor kapatıldı");
            } else {
                System.out.println("Timeout! Hala çalışıyor");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Shutdown çağrıldı
// Task'lar çalışmaya devam eder
// 3 saniye sonra executor kapatıldı (veya timeout)


