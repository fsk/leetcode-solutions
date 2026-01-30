package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 4: Reentrant Özelliği Gösterimi
 * 
 * Aynı thread'in aynı lock'u birden fazla kez alabilmesi.
 * ReentrantLock'un en önemli özelliği.
 */
public class ReentrantLockExample4 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer method: Lock alındı, lock count: " + lock.getHoldCount());
            innerMethod(); // Aynı thread içinde tekrar lock alıyor
        } finally {
            lock.unlock();
            System.out.println("Outer method: Lock bırakıldı");
        }
    }

    public static void innerMethod() {
        lock.lock(); // Aynı thread, aynı lock'u tekrar alıyor (reentrant)
        try {
            System.out.println("Inner method: Lock alındı, lock count: " + lock.getHoldCount());
        } finally {
            lock.unlock();
            System.out.println("Inner method: Lock bırakıldı, lock count: " + lock.getHoldCount());
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            outerMethod();
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Reentrant özelliği sayesinde deadlock olmadı!");
    }
}



