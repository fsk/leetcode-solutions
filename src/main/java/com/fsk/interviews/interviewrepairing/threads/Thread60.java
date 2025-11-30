package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 60: ThreadPoolExecutor queue types
 * 
 * Farklı queue tipleri thread pool davranışını nasıl etkiler?
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread60 {
    public static void main(String[] args) {
        // LinkedBlockingQueue: Sınırsız queue
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(
            2, 4, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>() // Sınırsız
        );
        
        // SynchronousQueue: Direkt geçiş, queue yok
        ThreadPoolExecutor executor2 = new ThreadPoolExecutor(
            2, 4, 60L, TimeUnit.SECONDS,
            new SynchronousQueue<>() // Queue yok, direkt thread'e geçer
        );
        
        // ArrayBlockingQueue: Sınırlı queue
        ThreadPoolExecutor executor3 = new ThreadPoolExecutor(
            2, 4, 60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5) // Max 5 element
        );
        
        System.out.println("LinkedBlockingQueue: Sınırsız queue");
        System.out.println("SynchronousQueue: Queue yok, direkt thread");
        System.out.println("ArrayBlockingQueue: Sınırlı queue (5)");
        
        executor1.shutdown();
        executor2.shutdown();
        executor3.shutdown();
    }
}

// ÇIKTI:
// LinkedBlockingQueue: Tüm task'lar queue'da bekler, thread sayısı artmaz
// SynchronousQueue: Queue yok, direkt thread'e geçer, thread sayısı artar
// ArrayBlockingQueue: Queue dolunca yeni thread oluşturulur


