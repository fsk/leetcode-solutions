package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 57: ThreadPoolExecutor beforeExecute ve afterExecute hooks
 * 
 * ThreadPoolExecutor'da task çalışmadan önce ve sonra hook'lar çalıştırabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread57 extends ThreadPoolExecutor {
    public Thread57() {
        super(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }
    
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("Before: " + t.getName() + " başlıyor");
    }
    
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("After: " + Thread.currentThread().getName() + " bitti");
        if (t != null) {
            System.out.println("Exception: " + t.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Thread57 executor = new Thread57();
        
        executor.submit(() -> System.out.println("Task 1 çalışıyor"));
        executor.submit(() -> System.out.println("Task 2 çalışıyor"));
        executor.submit(() -> {
            throw new RuntimeException("Test exception");
        });
        
        executor.shutdown();
        
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Before: pool-1-thread-1 başlıyor
// Task 1 çalışıyor
// After: pool-1-thread-1 bitti
// Before: pool-1-thread-2 başlıyor
// Task 2 çalışıyor
// After: pool-1-thread-2 bitti
// Before: pool-1-thread-1 başlıyor
// After: pool-1-thread-1 bitti
// Exception: Test exception


