package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 34: wait() ile timeout kullanımı
 * 
 * wait(timeout) ile belirli bir süre bekleyebiliriz.
 * Çıktı ne olur?
 */
public class Thread34 {
    private static final Object lock = new Object();
    private static boolean ready = false;
    
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                long startTime = System.currentTimeMillis();
                while (!ready) {
                    try {
                        long waitTime = 3000; // 3 saniye bekle
                        lock.wait(waitTime);
                        long elapsed = System.currentTimeMillis() - startTime;
                        if (!ready) {
                            System.out.println("Timeout! " + elapsed + " ms geçti");
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (ready) {
                    System.out.println("Thread uyandı!");
                }
            }
        });
        
        thread.start();
        
        // 5 saniye sonra notify yap (timeout'tan sonra)
        Thread notifier = new Thread(() -> {
            try {
                Thread.sleep(5000);
                synchronized (lock) {
                    ready = true;
                    lock.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        notifier.start();
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// Timeout! 3000 ms geçti
// (Thread timeout'tan sonra çıkar, notify gelmeden önce)


