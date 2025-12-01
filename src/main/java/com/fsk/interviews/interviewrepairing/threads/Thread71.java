package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 71: ForkJoinPool work-stealing algoritması
 * 
 * ForkJoinPool work-stealing ile idle thread'ler başka thread'lerin işini çalabilir.
 * Çıktı ne olur?
 */
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Thread71 {
    static class PrintAction extends RecursiveAction {
        private int start;
        private int end;
        private static final int THRESHOLD = 5;
        
        public PrintAction(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                // Base case
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            } else {
                // Divide
                int mid = (start + end) / 2;
                PrintAction left = new PrintAction(start, mid);
                PrintAction right = new PrintAction(mid, end);
                left.fork();
                right.compute(); // Current thread sağ tarafı yapsın
                left.join();
            }
        }
    }
    
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        PrintAction action = new PrintAction(0, 20);
        pool.invoke(action);
        pool.shutdown();
    }
}

// ÇIKTI:
// 0-19 arası sayılar yazdırılır
// Farklı thread'ler farklı aralıkları işler
// Work-stealing sayesinde thread'ler birbirinin işini çalabilir




