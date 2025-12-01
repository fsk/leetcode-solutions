package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 87: ExecutorService submit vs execute
 * 
 * submit() Future döner, execute() void döner.
 * Çıktı ne olur?
 */
import java.util.concurrent.*;

public class Thread87 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // execute: void döner, exception'ı handle edemez
        executor.execute(() -> {
            System.out.println("Execute: Task çalışıyor");
            throw new RuntimeException("Execute exception");
        });
        
        // submit: Future döner, exception'ı handle edebilir
        Future<?> future = executor.submit(() -> {
            System.out.println("Submit: Task çalışıyor");
            throw new RuntimeException("Submit exception");
        });
        
        try {
            Thread.sleep(1000);
            future.get(); // Exception burada yakalanır
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Submit exception yakalandı: " + e.getCause().getMessage());
        }
        
        executor.shutdown();
    }
}

// ÇIKTI:
// Execute: Task çalışıyor
// Submit: Task çalışıyor
// Submit exception yakalandı: Submit exception
// Execute exception uncaught exception handler'a gider




