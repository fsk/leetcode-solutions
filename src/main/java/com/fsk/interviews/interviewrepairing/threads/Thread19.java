package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 19: Thread context class loader
 * 
 * Her thread'in kendi class loader'ı olabilir.
 * Çıktı ne olur?
 */
public class Thread19 {
    public static void main(String[] args) {
        ClassLoader mainLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("Main class loader: " + mainLoader);
        
        Thread thread = new Thread(() -> {
            ClassLoader threadLoader = Thread.currentThread().getContextClassLoader();
            System.out.println("Thread class loader: " + threadLoader);
            
            // Context class loader'ı değiştir
            Thread.currentThread().setContextClassLoader(null);
            System.out.println("New class loader: " + Thread.currentThread().getContextClassLoader());
        });
        
        thread.start();
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Main class loader: sun.misc.Launcher$AppClassLoader@...
// Thread class loader: sun.misc.Launcher$AppClassLoader@... (parent'tan miras alır)
// New class loader: null


