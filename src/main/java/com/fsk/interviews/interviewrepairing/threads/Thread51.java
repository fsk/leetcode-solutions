package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 51: ThreadPoolExecutor core ve maximum pool size
 * 
 * ThreadPoolExecutor'da core pool size ve maximum pool size farkı nedir?
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread51 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,  // corePoolSize: minimum thread sayısı
            5,  // maximumPoolSize: maksimum thread sayısı
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10)
        );
        
        // 15 task gönder
        for (int i = 1; i <= 15; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Task " + id + " çalışıyor: " + 
                    Thread.currentThread().getName() + 
                    " (Active: " + executor.getActiveCount() + 
                    ", Pool: " + executor.getPoolSize() + ")");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        try {
            Thread.sleep(2000);
            System.out.println("Core pool size: " + executor.getCorePoolSize());
            System.out.println("Max pool size: " + executor.getMaximumPoolSize());
            System.out.println("Current pool size: " + executor.getPoolSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// İlk 2 task core thread'lerde çalışır
// Queue dolunca (10 task), yeni thread'ler oluşturulur (max 5'e kadar)
// Toplam 5 thread aktif olabilir
// Core pool size: 2, Max pool size: 5


