package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 88: ThreadPoolExecutor getActiveCount ve getCompletedTaskCount
 * 
 * ThreadPoolExecutor'dan istatistik bilgileri alabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread88 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 4, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>()
        );
        
        for (int i = 1; i <= 10; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        try {
            Thread.sleep(1000);
            System.out.println("Active count: " + executor.getActiveCount());
            System.out.println("Pool size: " + executor.getPoolSize());
            System.out.println("Completed task count: " + executor.getCompletedTaskCount());
            System.out.println("Task count: " + executor.getTaskCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Active count: (çalışan thread sayısı)
// Pool size: (toplam thread sayısı)
// Completed task count: (tamamlanan task sayısı)
// Task count: (toplam task sayısı)

