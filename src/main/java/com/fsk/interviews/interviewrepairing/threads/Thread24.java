package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 24: Instance method synchronization
 * 
 * Instance method'ları synchronized yapabiliriz.
 * Çıktı ne olur?
 */
public class Thread24 {
    private int counter = 0;
    
    public synchronized void increment() {
        counter++;
    }
    
    public synchronized int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) {
        Thread24 obj = new Thread24();
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.increment();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                obj.increment();
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
        
        System.out.println("Counter: " + obj.getCounter());
    }
}

// ÇIKTI:
// Counter: 2000 (her zaman doğru sonuç)
// synchronized instance method'lar aynı instance için lock kullanır


