package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 81: ExecutorService invokeAll
 * 
 * invokeAll ile birden fazla task'ı paralel çalıştırıp hepsinin bitmesini bekleyebiliriz.
 * Çıktı ne olur?
 */
import java.util.*;
import java.util.concurrent.*;

public class Thread81 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        List<Callable<String>> tasks = Arrays.asList(
            () -> {
                Thread.sleep(1000);
                return "Task 1";
            },
            () -> {
                Thread.sleep(2000);
                return "Task 2";
            },
            () -> {
                Thread.sleep(1500);
                return "Task 3";
            }
        );
        
        try {
            long start = System.currentTimeMillis();
            List<Future<String>> futures = executor.invokeAll(tasks);
            long elapsed = System.currentTimeMillis() - start;
            
            System.out.println("Tüm task'lar tamamlandı: " + elapsed + "ms");
            
            for (Future<String> future : futures) {
                System.out.println("Sonuç: " + future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Tüm task'lar tamamlandı: ~2000ms (en uzun task kadar)
// Sonuç: Task 1
// Sonuç: Task 2
// Sonuç: Task 3
// Tüm task'lar paralel çalışır, hepsi bitene kadar bekler


