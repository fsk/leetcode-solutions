package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 6: Condition ile Kullanım
 * 
 * Condition, synchronized'ın wait/notify mekanizmasına benzer.
 * await() ve signal() ile thread'ler arası koordinasyon.
 */
public class ReentrantLockExample6 {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean ready = false;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Producer: Veri hazırlanıyor...");
                Thread.sleep(2000);
                ready = true;
                System.out.println("Producer: Veri hazır, consumer'ı uyandırıyorum");
                condition.signal(); // Consumer'ı uyandır
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread consumer = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Consumer: Veri bekleniyor...");
                while (!ready) {
                    condition.await(); // Veri hazır olana kadar bekle
                }
                System.out.println("Consumer: Veri alındı, işleniyor...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        consumer.start();
        try {
            Thread.sleep(100); // Consumer'ın önce başlaması için
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



