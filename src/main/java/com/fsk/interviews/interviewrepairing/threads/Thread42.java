package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 42: Future ve Callable kullanımı
 * 
 * Callable ile değer döndüren task'lar oluşturabiliriz.
 * Future ile sonucu alabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread42 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        Future<Integer> future1 = executor.submit(() -> {
            Thread.sleep(1000);
            return 10;
        });
        
        Future<Integer> future2 = executor.submit(() -> {
            Thread.sleep(2000);
            return 20;
        });
        
        try {
            System.out.println("Future1 sonucu: " + future1.get()); // Blocking
            System.out.println("Future2 sonucu: " + future2.get()); // Blocking
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// (1 saniye bekler)
// Future1 sonucu: 10
// (1 saniye daha bekler)
// Future2 sonucu: 20
// get() metodu blocking'dir, sonuç gelene kadar bekler


