package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 45: ConcurrentHashMap kullanımı
 * 
 * ConcurrentHashMap thread-safe bir Map implementasyonudur.
 * Çıktı ne olur?
 */
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread45 {
    private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        // 5 thread aynı anda map'e yazıyor
        for (int i = 0; i < 5; i++) {
            final int id = i;
            executor.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    map.put("key" + id + "-" + j, j);
                }
            });
        }
        
        executor.shutdown();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Map size: " + map.size());
        System.out.println("Map thread-safe çalıştı");
    }
}

// ÇIKTI:
// Map size: 500 (5 thread * 100 entry)
// Map thread-safe çalıştı
// ConcurrentHashMap lock-free algoritma kullanır




