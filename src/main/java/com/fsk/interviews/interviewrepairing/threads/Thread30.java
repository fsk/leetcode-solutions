package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 30: Semaphore kullanımı
 * 
 * Semaphore ile aynı anda çalışabilecek thread sayısını sınırlayabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.Semaphore;

public class Thread30 {
    private static Semaphore semaphore = new Semaphore(2); // En fazla 2 thread
    
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            Thread thread = new Thread(() -> {
                try {
                    semaphore.acquire(); // İzin al
                    System.out.println("Thread " + id + " çalışıyor");
                    Thread.sleep(2000);
                    System.out.println("Thread " + id + " bitti");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // İzni serbest bırak
                }
            });
            thread.start();
        }
    }
}

// ÇIKTI:
// Aynı anda en fazla 2 thread çalışır
// Diğer thread'ler izin bekler
// Bir thread bitince, bekleyen thread'lerden biri çalışmaya başlar


