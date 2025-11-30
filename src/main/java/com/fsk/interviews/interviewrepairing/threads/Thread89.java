package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 89: ExecutorService uncaught exception handler
 * 
 * ExecutorService'de uncaught exception'ları handle edebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread89 {
    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler((t, e) -> {
                    System.out.println("Uncaught exception in " + t.getName() + ": " + e.getMessage());
                });
                return thread;
            }
        };
        
        ExecutorService executor = new ThreadPoolExecutor(
            2, 4, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            factory
        );
        
        executor.execute(() -> {
            throw new RuntimeException("Test exception");
        });
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Uncaught exception in pool-1-thread-1: Test exception
// Custom ThreadFactory ile exception handling yapabiliriz


