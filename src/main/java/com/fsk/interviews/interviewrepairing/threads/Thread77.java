package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 77: ForkJoinPool submit vs invoke
 * 
 * submit() Future döner, invoke() sonucu bekler.
 * Çıktı ne olur?
 */
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Thread77 {
    static class SumTask extends RecursiveTask<Integer> {
        private int[] array;
        private int start;
        private int end;
        
        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        protected Integer compute() {
            if (end - start <= 10) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask left = new SumTask(array, start, mid);
                SumTask right = new SumTask(array, mid, end);
                left.fork();
                int rightResult = right.compute();
                int leftResult = left.join();
                return leftResult + rightResult;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] array = new int[100];
        Arrays.fill(array, 1);
        
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        
        // invoke: Blocking, sonucu bekler
        Integer result1 = pool.invoke(task);
        System.out.println("Invoke result: " + result1);
        
        // submit: Non-blocking, Future döner
        SumTask task2 = new SumTask(array, 0, array.length);
        var future = pool.submit(task2);
        Integer result2 = future.join();
        System.out.println("Submit result: " + result2);
        
        pool.shutdown();
    }
}

// ÇIKTI:
// Invoke result: 100
// Submit result: 100
// invoke() direkt sonuç döner, submit() Future döner

