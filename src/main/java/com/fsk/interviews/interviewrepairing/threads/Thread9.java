package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 9: Thread state (durum) kontrolü
 * 
 * Thread'in durumunu kontrol edebiliriz.
 * Çıktı ne olur?
 */
public class Thread9 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        System.out.println("1. " + thread.getState()); // NEW
        thread.start();
        System.out.println("2. " + thread.getState()); // RUNNABLE
        try {
            Thread.sleep(100);
            System.out.println("3. " + thread.getState()); // TIMED_WAITING
            thread.join();
            System.out.println("4. " + thread.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// 1. NEW
// 2. RUNNABLE
// 3. TIMED_WAITING
// 4. TERMINATED


