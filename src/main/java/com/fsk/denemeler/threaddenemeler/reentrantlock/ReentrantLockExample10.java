package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 10: Gelişmiş Thread-Safe Counter (Zor Seviye)
 * 
 * Birden fazla Condition kullanarak:
 * - Okuma thread'leri için ayrı condition
 * - Yazma thread'leri için ayrı condition
 * - Read-write lock benzeri davranış
 */
public class ReentrantLockExample10 {
    private static int counter = 0;
    private static int readers = 0;
    private static boolean writing = false;
    
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition canRead = lock.newCondition();
    private static final Condition canWrite = lock.newCondition();

    public static void read(String threadName) {
        lock.lock();
        try {
            // Yazma işlemi varsa bekle
            while (writing) {
                System.out.println(threadName + ": Yazma işlemi var, bekleniyor...");
                canRead.await();
            }
            readers++;
            System.out.println(threadName + ": Okuyor, değer: " + counter + " (Readers: " + readers + ")");
            
            // Okuma simülasyonu
            Thread.sleep(500);
            
            readers--;
            if (readers == 0) {
                canWrite.signal(); // Tüm okumalar bitti, yazma yapılabilir
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(String threadName, int value) {
        lock.lock();
        try {
            // Okuma veya yazma işlemi varsa bekle
            while (writing || readers > 0) {
                System.out.println(threadName + ": Okuma/yazma işlemi var, bekleniyor...");
                canWrite.await();
            }
            writing = true;
            System.out.println(threadName + ": Yazıyor, eski değer: " + counter);
            
            // Yazma simülasyonu
            Thread.sleep(1000);
            counter = value;
            
            System.out.println(threadName + ": Yazdı, yeni değer: " + counter);
            writing = false;
            
            // Tüm bekleyen thread'leri uyandır
            canRead.signalAll();
            canWrite.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // Okuma thread'leri
        Thread reader1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                read("Reader-1");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread reader2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                read("Reader-2");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Yazma thread'leri
        Thread writer1 = new Thread(() -> {
            for (int i = 1; i <= 2; i++) {
                write("Writer-1", i * 10);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread writer2 = new Thread(() -> {
            for (int i = 1; i <= 2; i++) {
                write("Writer-2", i * 100);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        reader1.start();
        reader2.start();
        writer1.start();
        writer2.start();

        try {
            reader1.join();
            reader2.join();
            writer1.join();
            writer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal counter value: " + counter);
    }
}



