package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 4: Thread isimlendirme
 * 
 * Thread'lere isim vererek ayırt edebiliriz.
 * Çıktı ne olur?
 */
public class Thread4 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        
        thread1.start();
        thread2.start();
        
        System.out.println("Main: " + Thread.currentThread().getName());
    }
}

// ÇIKTI:
// "Main: main" yazılır
// "Thread-1" ve "Thread-2" yazılır (sıra garanti değil)

