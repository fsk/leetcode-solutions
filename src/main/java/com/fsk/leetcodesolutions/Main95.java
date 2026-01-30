package com.fsk.leetcodesolutions;

/**
 * Permutation
 */
public class Main95 {

    public static void main(String[] args) {
        // Permütasyon üretmek istediğimiz dizi
        Integer[] numbers = {1, 2, 3};
        System.out.println("Permütasyonlar:");
        printAllRecursive(numbers.length, numbers, ',');
    }

    /**
     * Heap's recursive algorithm
     * @param n         - eleman sayısı
     * @param elements  - permütasyonları alınacak dizi
     * @param delimiter - elemanlar arası ayraç
     * @param <T>       - generic tip
     */
    public static <T> void printAllRecursive(int n, T[] elements, char delimiter) {
        if (n == 1) {
            printArray(elements, delimiter);
        } else {
            for (int i = 0; i < n - 1; i++) {
                printAllRecursive(n - 1, elements, delimiter);
                // n çift ise i ile n-1'i değiştir
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
    }

    private static <T> void printArray(T[] elements, char delimiter) {
        for (T element : elements) {
            System.out.print(element + "" + delimiter + " ");
        }
        System.out.print('\n');
    }

    private static <T> void swap(T[] elements, int a, int b) {
        T temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}
