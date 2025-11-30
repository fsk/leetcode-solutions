package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 99: CompletableFuture get vs join
 * 
 * get() checked exception fırlatır, join() unchecked exception fırlatır.
 * Çıktı ne olur?
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Thread99 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Test error");
        });
        
        // get(): Checked exception
        try {
            @SuppressWarnings("unused")
            String result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("get() exception: " + e.getCause().getMessage());
        }
        
        // join(): Unchecked exception
        try {
            @SuppressWarnings("unused")
            String result = future.join();
        } catch (Exception e) {
            System.out.println("join() exception: " + e.getCause().getMessage());
        }
        
        // get() ile exception handling
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Success");
        try {
            String result = future2.get();
            System.out.println("get() result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // join() ile exception handling
        String result2 = future2.join();
        System.out.println("join() result: " + result2);
    }
}

// ÇIKTI:
// get() exception: Test error
// join() exception: Test error
// get() result: Success
// join() result: Success
// get() checked exception, join() unchecked exception

