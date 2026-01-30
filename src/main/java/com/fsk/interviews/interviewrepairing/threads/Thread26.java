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
                System.out.println("Thread 1: lock1 acquired");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1: lock2 acquired");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: lock2 acquired");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread 2: lock1 acquired");
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            Thread.sleep(2000);
            System.out.println("Program is still running?");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Thread 1: lock1 acquired
// Thread 2: lock2 acquired
// (Program takılır - deadlock)
// Thread 1 is waiting for lock2, Thread 2 is waiting for lock1


