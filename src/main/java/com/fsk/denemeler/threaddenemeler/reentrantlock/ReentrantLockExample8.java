package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 8: Nested Lock ve getHoldCount()
 * 
 * Lock'un kaç kez alındığını takip etme.
 * getHoldCount() ile lock seviyesini öğrenme.
 */
public class ReentrantLockExample8 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void level1() {
        lock.lock();
        try {
            System.out.println("Level 1: Lock count = " + lock.getHoldCount());
            level2();
        } finally {
            lock.unlock();
            System.out.println("Level 1: Lock bırakıldı, count = " + lock.getHoldCount());
        }
    }

    public static void level2() {
        lock.lock();
        try {
            System.out.println("Level 2: Lock count = " + lock.getHoldCount());
            level3();
        } finally {
            lock.unlock();
            System.out.println("Level 2: Lock bırakıldı, count = " + lock.getHoldCount());
        }
    }

    public static void level3() {
        lock.lock();
        try {
            System.out.println("Level 3: Lock count = " + lock.getHoldCount());
            System.out.println("En derin seviyede!");
        } finally {
            lock.unlock();
            System.out.println("Level 3: Lock bırakıldı, count = " + lock.getHoldCount());
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            level1();
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nLock bilgileri:");
        System.out.println("Is locked: " + lock.isLocked());
        System.out.println("Is held by current thread: " + lock.isHeldByCurrentThread());
        System.out.println("Queue length: " + lock.getQueueLength());
    }
}



