package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 26: Deadlock örneği
 * 
 * İki thread birbirinin lock'unu beklediğinde deadlock oluşur.
 * Çıktı ne olur?
 */
public class Thread26 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: lock1 aldı");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1: lock2 aldı");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: lock2 aldı");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread 2: lock1 aldı");
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            Thread.sleep(2000);
            System.out.println("Program hala çalışıyor mu?");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Thread 1: lock1 aldı
// Thread 2: lock2 aldı
// (Program takılır - deadlock)
// Thread 1 lock2'yi bekliyor, Thread 2 lock1'i bekliyor


