package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 75: RecursiveTask ile recursive hesaplama
 * 
 * RecursiveTask ile recursive hesaplamalar yapabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Thread75 {
    static class FibonacciTask extends RecursiveTask<Long> {
        private final int n;
        
        public FibonacciTask(int n) {
            this.n = n;
        }
        
        @Override
        protected Long compute() {
            if (n <= 1) {
                return (long) n;
            }
            
            FibonacciTask left = new FibonacciTask(n - 1);
            FibonacciTask right = new FibonacciTask(n - 2);
            
            left.fork();
            long rightResult = right.compute();
            long leftResult = left.join();
            
            return leftResult + rightResult;
        }
    }
    
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(10);
        long result = pool.invoke(task);
        System.out.println("Fibonacci(10) = " + result);
        pool.shutdown();
    }
}

// ÇIKTI:
// Fibonacci(10) = 55
// RecursiveTask ile recursive hesaplamalar paralel yapılabilir
// Not: Fibonacci için bu verimli değil, sadece örnek


