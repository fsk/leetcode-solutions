package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 7: tryLock(timeout) ile Timeout
 * 
 * Belirli bir süre lock almayı dener, alamazsa timeout olur.
 * Deadlock'ları önlemek için kullanışlıdır.
 */
public class ReentrantLockExample7 {
    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void method1() {
        lock1.lock();
        try {
            System.out.println("Thread 1: Lock1 aldı");
            Thread.sleep(1000);
            
            // Timeout ile lock2'yi almayı dene
            if (lock2.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println("Thread 1: Lock2 aldı");
                } finally {
                    lock2.unlock();
                }
            } else {
                System.out.println("Thread 1: Lock2 alınamadı (timeout)");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }
    }

    public static void method2() {
        lock2.lock();
        try {
            System.out.println("Thread 2: Lock2 aldı");
            Thread.sleep(1000);
            
            // Timeout ile lock1'i almayı dene
            if (lock1.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println("Thread 2: Lock1 aldı");
                } finally {
                    lock1.unlock();
                }
            } else {
                System.out.println("Thread 2: Lock1 alınamadı (timeout)");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> method1());
        Thread thread2 = new Thread(() -> method2());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Timeout sayesinde deadlock önlendi!");
    }
}



