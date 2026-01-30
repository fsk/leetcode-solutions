package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 56: ScheduledThreadPoolExecutor kullanımı
 * 
 * ScheduledThreadPoolExecutor ile periyodik ve gecikmeli task'lar çalıştırabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread56 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        
        // İlk çalışma: 1 saniye sonra, sonra her 2 saniyede bir
        ScheduledFuture<?> future1 = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Fixed rate task: " + System.currentTimeMillis());
        }, 1, 2, TimeUnit.SECONDS);
        
        // Önceki task bitince, 3 saniye sonra tekrar çalış
        ScheduledFuture<?> future2 = scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Fixed delay task: " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 3, TimeUnit.SECONDS);
        
        try {
            Thread.sleep(10000);
            future1.cancel(false);
            future2.cancel(false);
            System.out.println("Task'lar iptal edildi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        scheduler.shutdown();
    }
}

// ÇIKTI:
// Fixed rate: Her 2 saniyede bir (başlangıçtan itibaren)
// Fixed delay: Önceki task bitince 3 saniye sonra
// scheduleAtFixedRate vs scheduleWithFixedDelay farkı görülür




