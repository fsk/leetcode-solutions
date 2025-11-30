package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 48: ThreadLocal kullanımı (detaylı)
 * 
 * ThreadLocal ile her thread'in kendi değişkenini saklayabiliriz.
 * Çıktı ne olur?
 */
public class Thread48 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            System.out.println("Thread 1: " + threadLocal.get());
            threadLocal.set(threadLocal.get() + 10);
            System.out.println("Thread 1 güncellendi: " + threadLocal.get());
            threadLocal.remove(); // Memory leak'i önlemek için
        });
        
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println("Thread 2: " + threadLocal.get());
            threadLocal.set(threadLocal.get() + 20);
            System.out.println("Thread 2 güncellendi: " + threadLocal.get());
            threadLocal.remove();
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main thread: " + threadLocal.get()); // 0 (initial value)
    }
}

// ÇIKTI:
// Thread 1: 1
// Thread 1 güncellendi: 11
// Thread 2: 2
// Thread 2 güncellendi: 22
// Main thread: 0
// Her thread kendi değerini görür, diğerlerini görmez


