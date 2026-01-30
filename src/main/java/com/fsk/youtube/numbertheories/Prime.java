package com.fsk.youtube.numbertheories;

import java.util.stream.IntStream;

public class Prime {

    public static void main(String[] args) {

    }

    public static boolean isPrimeBasic(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeSqrt(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static boolean isPrimeRecursive(int n, int i) {
        if (n <= 1) return false;
        if (i * i > n) return true;
        if (n % i == 0) return false;
        return isPrimeRecursive(n, i + 1);
    }

    // 5️⃣ Stream API yöntemi (Java 8+)
    public static boolean isPrimeStream(int n) {
        if (n <= 1) return false;
        return IntStream.rangeClosed(2, (int)Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }
}
