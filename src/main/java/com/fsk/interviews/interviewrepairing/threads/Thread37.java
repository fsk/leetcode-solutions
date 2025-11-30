package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 37: CountDownLatch kullanımı
 * 
 * CountDownLatch ile thread'lerin belirli bir noktaya gelmesini bekleyebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.CountDownLatch;

public class Thread37 {
    private static CountDownLatch latch = new CountDownLatch(3);
    
    public static void main(String[] args) {
        // 3 worker thread
        for (int i = 1; i <= 3; i++) {
            final int id = i;
            Thread worker = new Thread(() -> {
                try {
                    System.out.println("Worker " + id + " çalışıyor");
                    Thread.sleep(1000);
                    System.out.println("Worker " + id + " bitti");
                    latch.countDown(); // Latch'i azalt
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            worker.start();
        }
        
        // Main thread tüm worker'ların bitmesini bekliyor
        try {
            System.out.println("Main thread bekliyor...");
            latch.await(); // Latch 0 olana kadar bekle
            System.out.println("Tüm worker'lar bitti, main devam ediyor");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Main thread bekliyor...
// Worker 1 çalışıyor
// Worker 2 çalışıyor
// Worker 3 çalışıyor
// Worker 1 bitti
// Worker 2 bitti
// Worker 3 bitti
// Tüm worker'lar bitti, main devam ediyor


