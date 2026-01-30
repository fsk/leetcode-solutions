package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 28: AtomicInteger kullanımı
 * 
 * AtomicInteger thread-safe bir şekilde integer işlemleri yapar.
 * Çıktı ne olur?
 */
import java.util.concurrent.atomic.AtomicInteger;

public class Thread28 {
    private static AtomicInteger counter = new AtomicInteger(0);
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter: " + counter.get());
    }
}

// ÇIKTI:
// Counter: 2000 (her zaman doğru sonuç)
// AtomicInteger synchronized'dan daha performanslıdır
// CAS (Compare-And-Swap) algoritması kullanır




