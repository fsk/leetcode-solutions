package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 8: Thread.join() kullanımı
 * 
 * join() metodu ile bir thread'in bitmesini bekleyebiliriz.
 * Çıktı ne olur?
 */
public class Thread8 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread is running");
                Thread.sleep(2000);
                System.out.println("Thread is finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        thread.start();
        
        try {
            thread.join(); // Thread'in bitmesini bekle
            System.out.println("Main thread is finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// "Thread is running" yazılır
// 2 saniye bekler
// "Thread is finished" yazılır
// "Main thread is finished" yazılır (join() sayesinde thread bitene kadar bekler)

