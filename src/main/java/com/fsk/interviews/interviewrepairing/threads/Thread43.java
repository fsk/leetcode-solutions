package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 43: ScheduledExecutorService kullanımı
 * 
 * ScheduledExecutorService ile periyodik veya gecikmeli task'lar çalıştırabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Thread43 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        
        // 2 saniye sonra çalış
        scheduler.schedule(() -> {
            System.out.println("Gecikmeli task çalıştı");
        }, 2, TimeUnit.SECONDS);
        
        // Her 1 saniyede bir çalış (3 kez)
        scheduler.scheduleAtFixedRate(() -> System.out.println("Periyodik task çalıştı"), 0, 1, TimeUnit.SECONDS);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        scheduler.shutdown();
    }
}

// ÇIKTI:
// Periyodik task çalıştı (hemen)
// Periyodik task çalıştı (1 saniye sonra)
// Gecikmeli task çalıştı (2 saniye sonra)
// Periyodik task çalıştı (2 saniye sonra)
// Periyodik task çalıştı (3 saniye sonra)
// ...




