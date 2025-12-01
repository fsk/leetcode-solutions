package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 41: ExecutorService temel kullanımı
 * 
 * ExecutorService ile thread pool kullanarak thread yönetimi yapabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread41 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Task " + id + " çalışıyor: " + 
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + id + " bitti");
            });
        }
        
        executor.shutdown(); // Yeni task kabul etme, mevcut task'ları bitir
        System.out.println("Executor shutdown çağrıldı");
    }
}

// ÇIKTI:
// Executor shutdown çağrıldı
// Task 1-3 çalışmaya başlar (3 thread pool'da)
// Task 1-3 bitti
// Task 4-5 çalışmaya başlar (boşalan thread'lerde)
// Task 4-5 bitti
// Thread pool'da en fazla 3 thread aynı anda çalışır




