package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 86: ThreadPoolExecutor allowCoreThreadTimeOut
 * 
 * allowCoreThreadTimeOut ile core thread'lerin de timeout'tan sonra kapanmasını sağlayabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread86 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 4, 2L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>()
        );
        
        executor.allowCoreThreadTimeOut(true); // Core thread'ler de timeout olsun
        
        executor.submit(() -> System.out.println("Task 1"));
        executor.submit(() -> System.out.println("Task 2"));
        
        try {
            Thread.sleep(1000);
            System.out.println("Pool size: " + executor.getPoolSize());
            
            Thread.sleep(3000); // keepAliveTime'dan fazla
            System.out.println("3 saniye sonra pool size: " + executor.getPoolSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Task 1
// Task 2
// Pool size: 2
// 3 saniye sonra pool size: 0 (core thread'ler de kapandı)
// allowCoreThreadTimeOut(false) olsaydı, core thread'ler açık kalırdı




