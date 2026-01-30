package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 82: ExecutorService invokeAny
 * 
 * invokeAny ile birden fazla task'tan ilk bitenin sonucunu alırız.
 * Çıktı ne olur?
 */
import java.util.*;
import java.util.concurrent.*;

public class Thread82 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        List<Callable<String>> tasks = Arrays.asList(
            () -> {
                Thread.sleep(2000);
                return "Task 1";
            },
            () -> {
                Thread.sleep(1000);
                return "Task 2";
            },
            () -> {
                Thread.sleep(1500);
                return "Task 3";
            }
        );
        
        try {
            long start = System.currentTimeMillis();
            String result = executor.invokeAny(tasks);
            long elapsed = System.currentTimeMillis() - start;
            
            System.out.println("İlk biten: " + result);
            System.out.println("Süre: " + elapsed + "ms");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// İlk biten: Task 2 (en hızlı)
// Süre: ~1000ms
// Diğer task'lar iptal edilir




