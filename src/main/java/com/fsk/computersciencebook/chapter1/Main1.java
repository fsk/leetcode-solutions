package com.fsk.computersciencebook.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main1 {

    static Map<Long, Long> MEMOIZATION_FIBO = new HashMap<>(Map.of(0L, 0L, 1L, 1L));

    public static void main(String[] args) {
        System.out.println(fibonacci1(50));
    }

    public static long fibonacci1(long n) {
        if (!MEMOIZATION_FIBO.containsKey(n)) {
            MEMOIZATION_FIBO.put(n, fibonacci1(n - 1) + fibonacci1(n - 2));
        }
        return MEMOIZATION_FIBO.get(n);
    }


//    public IntStream stream() {
//        int last = 0, next = 1;
//        return IntStream.generate(() -> {
//            int oldLast = last;
//            last = next;
//            next = oldLast + next;
//            return oldLast;
//        });
//    }
}
