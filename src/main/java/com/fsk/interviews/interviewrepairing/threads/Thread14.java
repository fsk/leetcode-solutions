package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 14: Thread.yield() kullanımı
 * 
 * yield() ile thread CPU'yu diğer thread'lere bırakır.
 * Çıktı ne olur?
 */
public class Thread14 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
                Thread.yield(); // CPU'yu bırak
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
                Thread.yield();
            }
        });
        
        thread1.start();
        thread2.start();
    }
}

// ÇIKTI:
// Thread 1 ve Thread 2 mesajları karışık yazılır
// yield() garanti değildir, sadece bir ipucudur
// JVM yield() çağrısını göz ardı edebilir


