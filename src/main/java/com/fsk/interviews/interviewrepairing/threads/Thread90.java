package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 90: ExecutorService custom rejection handler
 * 
 * Custom rejection handler ile reddedilen task'ları özelleştirebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread90 {
    static class CustomRejectionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task reddedildi: " + r.toString());
            System.out.println("Active threads: " + executor.getActiveCount());
            System.out.println("Queue size: " + executor.getQueue().size());
            // Alternatif: Başka bir executor'a gönder veya logla
        }
    }
    
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2),
            new CustomRejectionHandler()
        );
        
        // 5 task gönder (1 thread + 2 queue = 3 kabul, 2 reddedilir)
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor.submit(() -> {
                try {
                    System.out.println("Task " + id + " çalışıyor");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Task 1 çalışıyor
// Task 2 ve 3 queue'da bekler
// Task 4 ve 5 reddedilir (custom handler çalışır)
// Custom rejection handler ile reddedilen task'ları özelleştirebiliriz




