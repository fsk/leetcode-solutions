package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 21: Race condition problemi
 * 
 * Birden fazla thread aynı değişkene eriştiğinde race condition oluşur.
 * Çıktı ne olur?
 */
public class Thread21 {
    private static int counter = 0;
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread 1: " + counter);
                counter++;
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread 2: " + counter);
                counter++;
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
// Counter: 2000'den az olabilir (race condition)
// İki thread aynı anda counter++ yapmaya çalıştığında
// bazı artışlar kaybolabilir


