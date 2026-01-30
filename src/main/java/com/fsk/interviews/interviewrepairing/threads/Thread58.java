package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 58: ThreadPoolExecutor shutdown vs shutdownNow
 * 
 * shutdown() ve shutdownNow() arasındaki fark nedir?
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread58 {
    public static void main(String[] args) {
        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor1.submit(() -> {
                try {
                    System.out.println("Task " + id + " çalışıyor");
                    Thread.sleep(2000);
                    System.out.println("Task " + id + " bitti");
                } catch (InterruptedException e) {
                    System.out.println("Task " + id + " interrupt edildi");
                }
            });
        }
        
        executor1.shutdown(); // Yeni task kabul etmez, mevcut task'ları bitirir
        System.out.println("shutdown() çağrıldı");
        
        ExecutorService executor2 = Executors.newFixedThreadPool(2);
        
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            executor2.submit(() -> {
                try {
                    System.out.println("Task " + id + " çalışıyor");
                    Thread.sleep(2000);
                    System.out.println("Task " + id + " bitti");
                } catch (InterruptedException e) {
                    System.out.println("Task " + id + " interrupt edildi");
                }
            });
        }
        
        executor2.shutdownNow(); // Tüm task'ları interrupt eder
        System.out.println("shutdownNow() çağrıldı");
    }
}

// ÇIKTI:
// shutdown(): Mevcut task'lar bitene kadar bekler
// shutdownNow(): Tüm task'ları interrupt eder, hemen döner




