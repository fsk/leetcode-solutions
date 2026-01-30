package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 5: run() vs start() farkı
 * 
 * run() metodunu direkt çağırmak ile start() metodunu çağırmak arasındaki fark nedir?
 * Çıktı ne olur?
 */
public class Thread5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is running: " + Thread.currentThread().getName());
        });
        
        System.out.println("1. run() called:");
        thread.run();
        
        System.out.println("2. start() called:");
        thread.start();

        // Bir thread'i tekrar start() etmek hata verir
        //System.out.println("3. start() called: ");
        //thread.start();
    }
}

// ÇIKTI:
// 1. run() called:
// Thread is Running: main  (yeni thread oluşmaz, main thread'de çalışır)
// 2. start() called:
// Thread is Running: Thread-0  (yeni thread oluşur)

