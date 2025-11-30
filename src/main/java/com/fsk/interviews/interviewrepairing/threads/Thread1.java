package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 1: Thread oluşturmanın en basit yolu
 * 
 * Thread oluşturmanın iki yolu vardır:
 * 1. Thread sınıfını extend etmek
 * 2. Runnable interface'ini implement etmek
 * 
 * Bu örnekte Thread sınıfını extend ederek thread oluşturuyoruz.
 * Çıktı ne olur?
 */
public class Thread1 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("Main thread is running");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}

// ÇIKTI:
// "Main thread" veya "Thread çalışıyor" önce yazılabilir (non-deterministic)
// Her ikisi de yazılır ama sıra garanti değildir

