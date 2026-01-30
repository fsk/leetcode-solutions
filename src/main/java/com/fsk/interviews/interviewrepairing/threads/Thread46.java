package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 46: CopyOnWriteArrayList kullanımı
 * 
 * CopyOnWriteArrayList thread-safe bir List implementasyonudur.
 * Çıktı ne olur?
 */
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread46 {
    private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Writer thread
        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("Eklendi: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Reader thread'ler (paralel okuyabilir)
        for (int i = 0; i < 2; i++) {
            final int id = i;
            executor.submit(() -> {
                for (int j = 0; j < 5; j++) {
                    try {
                        Thread.sleep(200);
                        System.out.println("Reader " + id + " okudu: " + list);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
        System.out.println("Final list: " + list);
    }
}

// ÇIKTI:
// Eklendi ve okuma mesajları karışık yazılır
// CopyOnWriteArrayList okuma için snapshot kullanır
// Writer yazarken yeni bir array oluşturur




