package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 29: ReadWriteLock kullanımı
 * 
 * ReadWriteLock ile okuma ve yazma işlemlerini ayırabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Thread29 {
    private static int value = 0;
    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    
    public static void main(String[] args) {
        // Reader thread'ler (paralel çalışabilir)
        for (int i = 0; i < 3; i++) {
            final int id = i;
            Thread reader = new Thread(() -> {
                lock.readLock().lock();
                try {
                    System.out.println("Reader " + id + " okudu: " + value);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.readLock().unlock();
                }
            });
            reader.start();
        }
        
        // Writer thread (exclusive)
        Thread writer = new Thread(() -> {
            lock.writeLock().lock();
            try {
                value = 100;
                System.out.println("Writer yazdı: " + value);
            } finally {
                lock.writeLock().unlock();
            }
        });
        
        writer.start();
    }
}

// ÇIKTI:
// Reader'lar paralel çalışabilir (read lock paylaşılabilir)
// Writer exclusive çalışır (write lock paylaşılamaz)
// Reader ve writer aynı anda çalışamaz


