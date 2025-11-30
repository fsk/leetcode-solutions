package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 84: ThreadPoolExecutor prestartCoreThreads
 * 
 * prestartCoreThreads ile core thread'leri önceden başlatabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread84 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            3, 5, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>()
        );
        
        System.out.println("Başlangıç pool size: " + executor.getPoolSize());
        
        // Core thread'leri önceden başlat
        executor.prestartCoreThread();
        System.out.println("prestartCoreThread sonrası: " + executor.getPoolSize());
        
        executor.prestartAllCoreThreads();
        System.out.println("prestartAllCoreThreads sonrası: " + executor.getPoolSize());
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Başlangıç pool size: 0
// prestartCoreThread sonrası: 1
// prestartAllCoreThreads sonrası: 3 (core size)
// Thread'ler önceden başlatıldığı için ilk task'lar daha hızlı çalışır


