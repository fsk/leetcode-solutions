package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 18: Thread stack size
 * 
 * Thread'in stack boyutunu ayarlayabiliriz.
 * Çıktı ne olur?
 */
public class Thread18 {
    public static void main(String[] args) {
        // Stack size belirtilerek thread oluşturma
        Thread thread = new Thread(null, () -> {
            System.out.println("Thread is running");
            recursiveMethod(0);
        }, "MyThread", 1024 * 1024); // 1MB stack size
        
        thread.start();
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private static void recursiveMethod(int depth) {
        if (depth < 1000) {
            recursiveMethod(depth + 1);
        } else {
            System.out.println("Recursion is finished");
        }
    }
}

// ÇIKTI:
// Thread is running
// Recursion is finished


