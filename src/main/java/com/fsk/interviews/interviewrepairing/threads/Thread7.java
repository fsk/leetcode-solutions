package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 7: Thread.sleep() kullanımı
 * 
 * Thread.sleep() ile thread'i belirli bir süre bekletiyoruz.
 * Çıktı ne olur?
 */
public class Thread7 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread is started");
                Thread.sleep(2000); // 2 saniye bekle
                System.out.println("Thread is finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        thread.start();
        System.out.println("Main thread is finished");
    }
}

// ÇIKTI:
// "Main thread is finished" hemen yazılır
// "Thread is started" yazılır
// 2 saniye bekler
// "Thread is finished" yazılır

