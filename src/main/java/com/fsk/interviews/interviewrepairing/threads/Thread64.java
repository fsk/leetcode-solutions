package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 64: CompletableFuture allOf ve anyOf
 * 
 * allOf: Tüm future'ler bitene kadar bekler
 * anyOf: Herhangi biri bitince devam eder
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;

public class Thread64 {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 1";
        });
        
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 2";
        });
        
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 3";
        });
        
        // allOf: Tümü bitene kadar bekler
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2, future3);
        allOf.thenRun(() -> {
            System.out.println("Tüm task'lar tamamlandı");
            System.out.println("Future1: " + future1.join());
            System.out.println("Future2: " + future2.join());
            System.out.println("Future3: " + future3.join());
        });
        
        // anyOf: İlk biten
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2, future3);
        anyOf.thenAccept(result -> {
            System.out.println("İlk biten: " + result);
        });
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// İlk biten: Task 2 (en hızlı)
// Tüm task'lar tamamlandı
// Future1: Task 1
// Future2: Task 2
// Future3: Task 3

