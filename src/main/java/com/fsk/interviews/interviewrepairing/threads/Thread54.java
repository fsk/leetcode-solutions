package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 54: CachedThreadPool kullanımı
 * 
 * CachedThreadPool sınırsız thread oluşturabilir, idle thread'leri kapatır.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread54 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        // 100 task gönder
        for (int i = 1; i <= 100; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Task " + id + " çalışıyor: " + 
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        try {
            Thread.sleep(2000);
            System.out.println("Tüm task'lar tamamlandı");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// 100 task paralel çalışır (yeterli thread oluşturulur)
// Task'lar bitince idle thread'ler 60 saniye sonra kapanır
// CachedThreadPool yüksek throughput için uygundur


