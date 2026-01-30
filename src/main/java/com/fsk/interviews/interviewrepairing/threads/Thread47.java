package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 47: ForkJoinPool kullanımı
 * 
 * ForkJoinPool ile divide-and-conquer algoritmaları çalıştırabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Thread47 {
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
                // Base case: küçük parça
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Divide: ikiye böl
                int mid = (start + end) / 2;
                SumTask left = new SumTask(array, start, mid);
                SumTask right = new SumTask(array, mid, end);
                left.fork(); // Sol tarafı başlat
                int rightResult = right.compute(); // Sağ tarafı hesapla
                int leftResult = left.join(); // Sol tarafın sonucunu bekle
                return leftResult + rightResult;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        int result = pool.invoke(task);
        
        System.out.println("Toplam: " + result);
        pool.shutdown();
    }
}

// ÇIKTI:
// Toplam: 5050 (1+2+...+100)
// ForkJoinPool work-stealing algoritması kullanır




