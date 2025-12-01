package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 35: BlockingQueue kullanımı
 * 
 * BlockingQueue thread-safe bir queue'dur, wait/notify'i otomatik yapar.
 * Çıktı ne olur?
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Thread35 {
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
    
    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.put(i); // Queue doluysa otomatik bekler
                    System.out.println("Üretildi: " + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int value = queue.take(); // Queue boşsa otomatik bekler
                    System.out.println("Tüketildi: " + value);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        producer.start();
        consumer.start();
    }
}

// ÇIKTI:
// Üretildi ve tüketildi mesajları sırayla yazılır
// BlockingQueue wait/notify'i otomatik yapar
// put() ve take() thread-safe ve blocking'dir




