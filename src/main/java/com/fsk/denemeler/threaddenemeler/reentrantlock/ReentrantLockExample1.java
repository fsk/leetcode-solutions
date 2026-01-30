package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 1: Temel ReentrantLock Kullanımı
 * 
 * En basit seviye - ReentrantLock'un temel kullanımını gösterir.
 * lock() ve unlock() ile thread-safe counter artırma.
 */
public class ReentrantLockExample1 {
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter); // Her zaman 2000 olmalı
    }
}

