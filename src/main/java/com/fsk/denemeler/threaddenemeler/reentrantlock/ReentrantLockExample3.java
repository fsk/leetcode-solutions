package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 3: tryLock() Kullanımı
 * 
 * tryLock() ile lock alınamazsa beklemeden devam etme.
 * Non-blocking lock denemesi.
 */
public class ReentrantLockExample3 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1: Lock aldı, 2 saniye bekliyor...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Thread 1: Lock'u bıraktı");
            }
        });

        Thread thread2 = new Thread(() -> {
            // tryLock() ile lock almayı dene
            if (lock.tryLock()) {
                try {
                    System.out.println("Thread 2: Lock aldı!");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Thread 2: Lock alınamadı, başka işler yapıyor...");
            }
        });

        thread1.start();
        try {
            Thread.sleep(100); // Thread 1'in lock alması için kısa bir süre bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start(); // Thread 2 lock almayı deneyecek ama alamayacak

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



