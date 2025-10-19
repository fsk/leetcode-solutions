package com.fsk.youtube.binarysearch;

public class Main1 {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        // Arama, sol ve sağ sınırlar çakışana kadar devam eder
        while (left <= right) {
            // Ortadaki elemanı bul
            int mid = (left + right) >>> 1; // (left + right) / 2 ile aynı

            // Ortadaki değeri kontrol et
            if (array[mid] == target) {
                return mid; // bulundu!
            }

            // Aranan sayı ortadakinden küçükse → sola git
            if (target < array[mid]) {
                right = mid - 1;
            }
            // Aranan sayı ortadakinden büyükse → sağa git
            else {
                left = mid + 1;
            }
        }

        // Bulunamadıysa -1 döner
        return -1;
    }
}
