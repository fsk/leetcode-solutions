package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 20: Thread local storage
 * 
 * Her thread'in kendi lokal değişkeni olabilir (ThreadLocal).
 * Çıktı ne olur?
 */
public class Thread20 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    
    public static void main(String[] args) {
        threadLocal.set(100); // Main thread için
        
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            System.out.println("Thread 1: " + threadLocal.get());
        });
        
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println("Thread 2: " + threadLocal.get());
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main thread: " + threadLocal.get());
    }
}

// ÇIKTI:
// Thread 1: 1
// Thread 2: 2
// Main thread: 100
// Her thread kendi değerini görür, diğerlerini görmez


