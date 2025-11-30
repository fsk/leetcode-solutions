package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 40: Phaser kullanımı
 * 
 * Phaser ile esnek senkronizasyon yapabiliriz (CountDownLatch + CyclicBarrier gibi).
 * Çıktı ne olur?
 */
import java.util.concurrent.Phaser;

public class Thread40 {
    private static Phaser phaser = new Phaser(3); // 3 thread kayıtlı
    
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            final int id = i;
            Thread thread = new Thread(() -> {
                System.out.println("Thread " + id + " faz 0'da");
                phaser.arriveAndAwaitAdvance(); // Faz 0'ı tamamla, faz 1'e geç
                
                System.out.println("Thread " + id + " faz 1'de");
                phaser.arriveAndAwaitAdvance(); // Faz 1'i tamamla, faz 2'ye geç
                
                System.out.println("Thread " + id + " faz 2'de");
                phaser.arriveAndDeregister(); // Faz 2'yi tamamla, kayıttan çık
            });
            thread.start();
        }
        
        try {
            Thread.sleep(3000);
            System.out.println("Phaser faz sayısı: " + phaser.getPhase());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Thread 1 faz 0'da
// Thread 2 faz 0'da
// Thread 3 faz 0'da
// Thread 1 faz 1'de
// Thread 2 faz 1'de
// Thread 3 faz 1'de
// Thread 1 faz 2'de
// Thread 2 faz 2'de
// Thread 3 faz 2'de
// Phaser faz sayısı: 2
// Tüm thread'ler aynı fazda ilerler


