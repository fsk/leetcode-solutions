package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 22: synchronized method kullanımı
 * 
 * synchronized keyword ile race condition'ı çözebiliriz.
 * Çıktı ne olur?
 */
public class Thread22 {
    private static int counter = 0;
    
    public static synchronized void increment() {
        counter++;
    }
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread 1: " + counter);
                increment();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread 2: " + counter);
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
// Counter: 2000 (her zaman doğru sonuç)
// synchronized sayesinde thread'ler sırayla çalışır


