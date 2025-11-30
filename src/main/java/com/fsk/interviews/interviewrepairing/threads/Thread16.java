package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 16: Thread exception handling
 * 
 * Thread içinde oluşan exception'lar nasıl handle edilir?
 * Çıktı ne olur?
 */
public class Thread16 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread başladı");
            @SuppressWarnings("unused")
            int result = 10 / 0; // ArithmeticException
            System.out.println("Bu satır çalışmaz");
        });
        
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Exception yakalandı: " + e.getMessage());
        });
        
        thread.start();
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main thread devam ediyor");
    }
}

// ÇIKTI:
// Thread başladı
// Exception yakalandı: / by zero
// Main thread devam ediyor
// (Thread exception'ı main thread'i etkilemez)

