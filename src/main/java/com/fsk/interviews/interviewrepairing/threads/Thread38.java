package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 38: CyclicBarrier kullanımı
 * 
 * CyclicBarrier ile thread'lerin belirli bir noktada buluşmasını sağlayabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Thread38 {
    private static CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        System.out.println("Tüm thread'ler bariyere ulaştı!");
    });
    
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            final int id = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread " + id + " bariyere doğru ilerliyor");
                    Thread.sleep(1000 * id); // Farklı hızlarda
                    System.out.println("Thread " + id + " bariyere ulaştı");
                    barrier.await(); // Bariyere ulaş, diğerlerini bekle
                    System.out.println("Thread " + id + " bariyerden sonra devam ediyor");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}

// ÇIKTI:
// Thread 1 bariyere doğru ilerliyor
// Thread 2 bariyere doğru ilerliyor
// Thread 3 bariyere doğru ilerliyor
// Thread 1 bariyere ulaştı
// Thread 2 bariyere ulaştı
// Thread 3 bariyere ulaştı
// Tüm thread'ler bariyere ulaştı! (barrier action)
// Thread 1 bariyerden sonra devam ediyor
// Thread 2 bariyerden sonra devam ediyor
// Thread 3 bariyerden sonra devam ediyor


