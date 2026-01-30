package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 10: Daemon thread
 * 
 * Daemon thread'ler, main thread bittiğinde otomatik olarak sonlanır.
 * Normal thread'ler ise program çalışmaya devam eder.
 * Çıktı ne olur?
 */
public class Thread10 {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        daemonThread.setDaemon(true); // Daemon thread olarak işaretle
        daemonThread.start();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main thread is finished");
    }
}

// ÇIKTI:
// "Daemon thread çalışıyor" birkaç kez yazılır
// "Main thread bitti" yazılır
// Program sonlanır (daemon thread otomatik sonlanır)
// Eğer daemon olmasaydı, program sonsuz döngüde kalırdı


