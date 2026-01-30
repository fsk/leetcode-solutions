package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 31: wait() ve notify() temel kullanımı
 * 
 * wait() ile thread bekletilir, notify() ile uyandırılır.
 * Çıktı ne olur?
 */
public class Thread31 {
    private static final Object lock = new Object();
    private static boolean ready = false;
    
    public static void main(String[] args) {
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                while (!ready) {
                    try {
                        System.out.println("Thread bekliyor...");
                        lock.wait(); // Lock'ı bırak ve bekle
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread uyandı!");
            }
        });
        
        Thread notifyingThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                synchronized (lock) {
                    ready = true;
                    lock.notify(); // Bekleyen thread'i uyandır
                    System.out.println("Thread uyandırıldı");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        waitingThread.start();
        notifyingThread.start();
        
        try {
            waitingThread.join();
            notifyingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Thread bekliyor...
// (2 saniye bekler)
// Thread uyandırıldı
// Thread uyandı!




