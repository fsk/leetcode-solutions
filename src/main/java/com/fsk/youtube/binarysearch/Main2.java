package com.fsk.youtube.binarysearch;

public class Main2 {

    public static long findSumBinarySearch(int x, int y) {

        // Aralık sınırları (int sınırlarını long’a taşıyoruz)
        long low = (long) Integer.MIN_VALUE;
        long high = (long) Integer.MAX_VALUE;

        // Aranan hedef toplam
        long target = (long) x + y;

        // Binary search başlıyor
        while (low <= high) {
            long mid = (low + high) >>> 1; // ortayı al

            if (mid == target) {
                // ortadaki değer hedef toplamla eşleşti
                return mid;
            } else if (mid < target) {
                low = mid + 1; // sağa git
            } else {
                high = mid - 1; // sola git
            }
        }

        // bulunamadıysa
        return -1;
    }
}
