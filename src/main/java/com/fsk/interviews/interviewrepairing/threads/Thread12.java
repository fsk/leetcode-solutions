package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 12: Thread.interrupt() kullanımı
 * 
 * interrupt() ile bir thread'i kesintiye uğratabiliriz.
 * Çıktı ne olur?
 */
public class Thread12 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted");
                    Thread.currentThread().interrupt(); // Interrupt flag'ini tekrar set et
                    break;
                }
            }
            System.out.println("Thread is finished");
        });
        
        thread.start();
        
        try {
            Thread.sleep(3000);
            thread.interrupt(); // Thread'i kesintiye uğrat
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// "Thread is running" birkaç kez yazılır
// "Thread is interrupted" yazılır
// "Thread is finished" yazılır


