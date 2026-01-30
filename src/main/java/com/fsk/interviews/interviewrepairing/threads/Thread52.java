package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 52: ThreadPoolExecutor keepAliveTime
 * 
 * keepAliveTime ile core thread'lerden fazla thread'lerin ne kadar süre yaşayacağını belirleriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread52 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 4,  // core: 2, max: 4
            2L, TimeUnit.SECONDS,  // keepAliveTime: 2 saniye
            new LinkedBlockingQueue<>(5)
        );
        
        // 10 task gönder
        for (int i = 1; i <= 10; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Task " + id + " çalışıyor, Pool size: " + 
                    executor.getPoolSize());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        try {
            Thread.sleep(1000);
            System.out.println("1 saniye sonra - Pool size: " + executor.getPoolSize());
            Thread.sleep(2000);
            System.out.println("3 saniye sonra - Pool size: " + executor.getPoolSize());
            // keepAliveTime'dan sonra fazla thread'ler kapanır
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Task'lar çalışırken pool size 4'e çıkar
// Task'lar bitince, 2 saniye sonra fazla thread'ler kapanır
// Pool size core size'a (2) döner




