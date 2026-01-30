package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 55: SingleThreadExecutor kullanımı
 * 
 * SingleThreadExecutor sırayla task'ları çalıştırır.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread55 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Task " + id + " çalışıyor: " + 
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor.shutdown();
        
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Tüm task'lar sırayla tamamlandı");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Task 1 çalışıyor: pool-1-thread-1
// Task 2 çalışıyor: pool-1-thread-1
// Task 3 çalışıyor: pool-1-thread-1
// Task 4 çalışıyor: pool-1-thread-1
// Task 5 çalışıyor: pool-1-thread-1
// Tüm task'lar aynı thread'de sırayla çalışır




