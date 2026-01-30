package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 25: Reentrant lock
 * 
 * Aynı thread aynı lock'ı birden fazla kez alabilir (reentrant).
 * Çıktı ne olur?
 */
public class Thread25 {
    private static int counter = 0;
    private static final Object lock = new Object();
    
    public static void increment() {
        synchronized (lock) {
            counter++;
            incrementAgain(); // Aynı lock'ı tekrar kullanıyor
        }
    }
    
    public static void incrementAgain() {
        synchronized (lock) { // Aynı thread, aynı lock - deadlock olmaz
            counter++;
        }
    }
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                increment();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                increment();
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter: " + counter);
    }
}

// ÇIKTI:
// Counter: 2000 (her increment 2 kez artırıyor)
// Java lock'ları reentrant'tır, aynı thread aynı lock'ı tekrar alabilir


