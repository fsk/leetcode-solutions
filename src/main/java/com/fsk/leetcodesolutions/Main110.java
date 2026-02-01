package com.fsk.leetcodesolutions;

public class Main110 {
    public static void main(String[] args) {
        //System.out.println(getBinary(10));
        //System.out.println(Integer.bitCount(10));

        System.out.println(countPrimeSetBits(6, 10));
        System.out.println(countPrimeSetBits(10, 15));
    }
//    public static int countPrimeSetBits(int left, int right) {
//
//    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int binaryCount = Integer.bitCount(i);
            if (isPrime(binaryCount)) count++;
        }
        return count;
    }

    private static String getBits(int a) {
        StringBuilder binary = new StringBuilder();
        while (a > 0) {
            int res = a % 2;
            a = a / 2;
            binary.append(res);
        }
        return binary.reverse().toString();
    }

    private static int getBinaryCount(String a) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1') count++;
        }
        return count;
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }


}
