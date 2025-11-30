package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 10: Autoboxing performance trick
 * 
 * Autoboxing performance etkisi
 * Loop içinde autoboxing
 * Çıktı ne olur?
 */
public class Basic10 {
    public static void main(String[] args) {
        // Performance test
        long start1 = System.currentTimeMillis();
        Integer sum1 = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum1 += i; // Her iterasyonda unbox, add, box!
        }
        long time1 = System.currentTimeMillis() - start1;
        System.out.println("With autoboxing: " + time1 + "ms, sum: " + sum1);
        
        long start2 = System.currentTimeMillis();
        int sum2 = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum2 += i; // No boxing/unboxing
        }
        long time2 = System.currentTimeMillis() - start2;
        System.out.println("Without autoboxing: " + time2 + "ms, sum: " + sum2);
        
        // Collection'da autoboxing
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i); // Autoboxing
        }
        System.out.println("List size: " + list.size());
    }
}

// ÇIKTI:
// With autoboxing: (daha yavaş - her iterasyonda box/unbox)
// Without autoboxing: (daha hızlı)
// Autoboxing performance overhead yaratır
// Loop içinde primitive kullanmak daha performanslıdır


