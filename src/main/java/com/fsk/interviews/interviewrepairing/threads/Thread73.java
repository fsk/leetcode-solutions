package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 73: Parallel Stream thread safety
 * 
 * Parallel stream'de thread-safe olmayan işlemler sorun yaratabilir.
 * Çıktı ne olur?
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Thread73 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Thread-safe olmayan (yanlış)
        List<Integer> unsafe = new ArrayList<>();
        numbers.parallelStream()
            .forEach(n -> unsafe.add(n * 2)); // Race condition!
        
        System.out.println("Unsafe size: " + unsafe.size()); // 10'dan az olabilir
        
        // Thread-safe (doğru)
        List<Integer> safe = numbers.parallelStream()
            .map(n -> n * 2)
            .collect(Collectors.toList());
        
        System.out.println("Safe size: " + safe.size()); // Her zaman 10
        System.out.println("Safe: " + safe);
    }
}

// ÇIKTI:
// Unsafe size: 10'dan az olabilir (race condition)
// Safe size: 10 (her zaman doğru)
// Safe: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
// collect() thread-safe, forEach() ile add() thread-safe değil




