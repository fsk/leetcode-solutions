package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 53: ThreadPoolExecutor rejection policies
 * 
 * Farklı rejection policy'lerin davranışı nedir?
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread53 {
    public static void main(String[] args) {
        // AbortPolicy (varsayılan): Exception fırlatır
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1),
            new ThreadPoolExecutor.AbortPolicy()
        );
        
        try {
            executor1.submit(() -> System.out.println("Task 1"));
            executor1.submit(() -> System.out.println("Task 2"));
            executor1.submit(() -> System.out.println("Task 3")); // RejectedExecutionException
        } catch (RejectedExecutionException e) {
            System.out.println("Task reddedildi: " + e.getClass().getSimpleName());
        }
        
        executor1.shutdown();
        
        // CallerRunsPolicy: Caller thread'de çalıştırır
        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1),
            new ThreadPoolExecutor.CallerRunsPolicy()
        );
        
        executor2.submit(() -> System.out.println("Task A"));
        executor2.submit(() -> System.out.println("Task B"));
        executor2.submit(() -> System.out.println("Task C")); // Main thread'de çalışır
        
        executor2.shutdown();
    }
}

// ÇIKTI:
// Task 1
// Task 2
// Task reddedildi: RejectedExecutionException
// Task A
// Task B
// Task C (main thread'de çalışır)




