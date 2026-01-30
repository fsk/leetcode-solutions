package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 17: Thread group kullanımı
 * 
 * Thread'leri gruplara ayırabiliriz.
 * Çıktı ne olur?
 */
public class Thread17 {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("MyThreadGroup");
        
        Thread thread1 = new Thread(group, () -> {
            System.out.println("Thread 1: " + Thread.currentThread().getThreadGroup().getName());
        });
        
        Thread thread2 = new Thread(group, () -> {
            System.out.println("Thread 2: " + Thread.currentThread().getThreadGroup().getName());
        });
        
        thread1.start();
        thread2.start();
        
        System.out.println("Active threads: " + group.activeCount());
    }
}

// ÇIKTI:
// Thread 1: MyThreadGroup
// Thread 2: MyThreadGroup
// Active threads: 2 (veya daha fazla, main thread de sayılabilir)


