package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 49: Thread pool rejection policy
 * 
 * Thread pool dolu olduğunda yeni task'lar için rejection policy belirleyebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread49 {
    public static void main(String[] args) {
        // 2 thread'li pool, 3'lük queue
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 2, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(3),
            new ThreadPoolExecutor.CallerRunsPolicy() // Rejection policy
        );
        
        // 10 task gönder (5 task kabul edilebilir: 2 thread + 3 queue)
        for (int i = 1; i <= 10; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Task " + id + " çalışıyor: " + 
                    Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor.shutdown();
        
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// İlk 5 task kabul edilir (2 thread + 3 queue)
// Diğer task'lar CallerRunsPolicy sayesinde main thread'de çalışır
// veya exception fırlatılır (policy'ye göre)


