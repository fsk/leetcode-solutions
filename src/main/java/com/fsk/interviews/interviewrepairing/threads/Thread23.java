package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 23: synchronized block kullanımı
 * 
 * synchronized block ile sadece kritik bölgeyi koruyabiliriz.
 * Çıktı ne olur?
 */
public class Thread23 {
    private static int counter = 0;
    private static final Object lock = new Object();
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    counter++;
                }
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
// Counter: 2000 (her zaman doğru sonuç)
// synchronized block sadece kritik bölgeyi korur


