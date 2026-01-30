package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 59: Custom ThreadFactory kullanımı
 * 
 * Custom ThreadFactory ile thread'leri özelleştirebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread59 {
    static class CustomThreadFactory implements ThreadFactory {
        private int counter = 0;
        
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("CustomThread-" + (++counter));
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }
    
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(
            2, 4, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new CustomThreadFactory()
        );
        
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Task " + id + " çalışıyor: " + 
                    Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Task'lar CustomThread-1, CustomThread-2, ... isimli thread'lerde çalışır
// Custom ThreadFactory ile thread özelliklerini kontrol edebiliriz




