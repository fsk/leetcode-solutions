package com.fsk;

/**
 * LeetCode -> 338. Counting Bits
 */
public class Main65 {

    public static void main(String[] args) {

        int[] arr = countBits(5);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] countBits(int n) {
        int arr[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = getBits(i).length();
        }
        return arr;
    }

    private static String getBits(int i) {
        StringBuilder s = new StringBuilder();
        while (i > 0) {
            int bolum =  (i / 2);
            int kalan = i - (bolum * 2);
            i = bolum;
            s.append(kalan);
        }
        return s.reverse().toString().replace("0", "");
    }
}
