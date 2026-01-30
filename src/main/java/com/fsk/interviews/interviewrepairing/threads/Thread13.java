package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 13: Thread.currentThread() kullanımı
 * 
 * currentThread() ile mevcut thread'i alabiliriz.
 * Çıktı ne olur?
 */
public class Thread13 {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());
        
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: " + Thread.currentThread().getName());
        });
        
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: " + Thread.currentThread().getName());
        });
        
        thread1.start();
        thread2.start();
    }
}

// ÇIKTI:
// Main thread: main
// Thread 1: Thread-0 (veya Thread-1)
// Thread 2: Thread-1 (veya Thread-0)
// Sıra garanti değildir


