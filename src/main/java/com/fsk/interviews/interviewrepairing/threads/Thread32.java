package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 32: notifyAll() kullanımı
 * 
 * notifyAll() ile tüm bekleyen thread'ler uyandırılır.
 * Çıktı ne olur?
 */
public class Thread32 {
    private static final Object lock = new Object();
    private static boolean ready = false;
    
    public static void main(String[] args) {
        // 3 thread bekliyor
        for (int i = 1; i <= 3; i++) {
            final int id = i;
            Thread thread = new Thread(() -> {
                synchronized (lock) {
                    while (!ready) {
                        try {
                            System.out.println("Thread " + id + " bekliyor");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Thread " + id + " uyandı");
                }
            });
            thread.start();
        }
        
        // Notifier thread
        Thread notifier = new Thread(() -> {
            try {
                Thread.sleep(2000);
                synchronized (lock) {
                    ready = true;
                    lock.notifyAll(); // Tüm thread'leri uyandır
                    System.out.println("Tüm thread'ler uyandırıldı");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        notifier.start();
    }
}

// ÇIKTI:
// Thread 1 bekliyor
// Thread 2 bekliyor
// Thread 3 bekliyor
// (2 saniye bekler)
// Tüm thread'ler uyandırıldı
// Thread 1 uyandı
// Thread 2 uyandı
// Thread 3 uyandı (sıra garanti değil)


