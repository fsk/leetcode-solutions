package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 5: Fair Lock Kullanımı
 * 
 * Fair lock, lock'u bekleyen thread'lere sırayla (FIFO) verir.
 * Unfair lock (varsayılan) daha hızlıdır ama adil değildir.
 */
public class ReentrantLockExample5 {
    private static final ReentrantLock fairLock = new ReentrantLock(true); // Fair lock
    private static final ReentrantLock unfairLock = new ReentrantLock(false); // Unfair lock

    public static void useFairLock(String threadName) {
        fairLock.lock();
        try {
            System.out.println(threadName + " fair lock aldı");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            fairLock.unlock();
        }
    }

    public static void useUnfairLock(String threadName) {
        unfairLock.lock();
        try {
            System.out.println(threadName + " unfair lock aldı");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            unfairLock.unlock();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Fair Lock Test ===");
        for (int i = 1; i <= 5; i++) {
            final int threadNum = i;
            new Thread(() -> useFairLock("Thread-" + threadNum)).start();
            try {
                Thread.sleep(10); // Thread'lerin sırayla başlaması için
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Unfair Lock Test ===");
        for (int i = 1; i <= 5; i++) {
            final int threadNum = i;
            new Thread(() -> useUnfairLock("Thread-" + threadNum)).start();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



