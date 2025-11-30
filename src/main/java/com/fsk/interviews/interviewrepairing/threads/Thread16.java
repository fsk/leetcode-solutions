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
            System.out.println("Thread is started");
            @SuppressWarnings("unused")
            int result = 10 / 0; // ArithmeticException
            System.out.println("This line will not be executed");
        });
        
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Exception caught: " + e.getMessage());
        });
        
        thread.start();
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main thread is running");
    }
}

// ÇIKTI:
// Thread is started
// Exception caught: / by zero
// Main thread is running
// (Thread exception'ı main thread'i etkilemez)

