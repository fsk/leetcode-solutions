package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 36: Condition kullanımı
 * 
 * Condition ile daha esnek bekleme/uyandırma yapabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread36 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static boolean ready = false;
    
    public static void main(String[] args) {
        Thread waitingThread = new Thread(() -> {
            lock.lock();
            try {
                while (!ready) {
                    System.out.println("Thread bekliyor...");
                    condition.await(); // Condition'da bekle
                }
                System.out.println("Thread uyandı!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        
        Thread notifyingThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                lock.lock();
                try {
                    ready = true;
                    condition.signal(); // Bekleyen thread'i uyandır
                    System.out.println("Thread uyandırıldı");
                } finally {
                    lock.unlock();
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
// Condition, Lock ile birlikte kullanılır




