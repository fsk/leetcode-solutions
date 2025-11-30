package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 33: Producer-Consumer basit örnek
 * 
 * Producer üretir, Consumer tüketir.
 * Çıktı ne olur?
 */
import java.util.LinkedList;
import java.util.Queue;

public class Thread33 {
    private static final int CAPACITY = 5;
    private static Queue<Integer> queue = new LinkedList<>();
    private static final Object lock = new Object();
    
    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (lock) {
                    while (queue.size() == CAPACITY) {
                        try {
                            lock.wait(); // Queue dolu, bekle
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(i);
                    System.out.println("Üretildi: " + i);
                    lock.notify(); // Consumer'ı uyandır
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (lock) {
                    while (queue.isEmpty()) {
                        try {
                            lock.wait(); // Queue boş, bekle
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = queue.poll();
                    System.out.println("Tüketildi: " + value);
                    lock.notify(); // Producer'ı uyandır
                }
                try {
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
// Producer hızlı, Consumer yavaş olduğu için queue dolabilir
// wait/notify ile senkronizasyon sağlanır


