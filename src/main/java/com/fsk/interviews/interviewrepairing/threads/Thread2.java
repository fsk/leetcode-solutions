package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 2: Runnable interface ile thread oluşturma
 * 
 * Runnable interface'ini implement ederek thread oluşturuyoruz.
 * Thread sınıfına Runnable objesi geçiriyoruz.
 * Çıktı ne olur?
 */
public class Thread2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Main thread is running");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable is running");
    }
}

// ÇIKTI:
// "Main thread" veya "Runnable çalışıyor" önce yazılabilir
// Her ikisi de yazılır

