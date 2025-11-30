package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 50: Thread-safe singleton pattern
 * 
 * Thread-safe singleton pattern'i farklı yöntemlerle implement edebiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread50 {
    // Double-checked locking ile thread-safe singleton
    private static volatile Thread50 instance;
    
    private Thread50() {
        System.out.println("Singleton instance oluşturuldu");
    }
    
    public static Thread50 getInstance() {
        if (instance == null) {
            synchronized (Thread50.class) {
                if (instance == null) {
                    instance = new Thread50();
                }
            }
        }
        return instance;
    }
    
    public void doSomething() {
        System.out.println("Singleton çalışıyor: " + this);
    }
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        // 10 thread aynı anda singleton istiyor
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                Thread50 singleton = Thread50.getInstance();
                singleton.doSomething();
            });
        }
        
        executor.shutdown();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Singleton instance oluşturuldu (sadece 1 kez)
// Singleton çalışıyor: ... (10 kez, aynı instance)
// Double-checked locking ile thread-safe ve performanslı


