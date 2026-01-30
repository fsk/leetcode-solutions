package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 6: Birden fazla thread çalıştırma
 * 
 * Birden fazla thread aynı anda çalıştırıldığında ne olur?
 * Çıktı ne olur?
 */
public class Thread6 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            Thread thread = new Thread(() -> {
                System.out.println("Thread " + num + " is running");
            });
            thread.start();
        }
        System.out.println("Main thread is finished");
    }
}

// ÇIKTI:
// "Main thread is finished" önce yazılabilir
// Thread 1-5 mesajları karışık sırada yazılır (non-deterministic)
// Her thread farklı zamanlarda is running

