package com.fsk.starpatterns;

public class Pattern5 {

    public static void main(String[] args) {

        int n = 5;

        for (int x = 1; x <= n; x++) {
            // Her satır için boşlukları yazdır, ilk satırda n-1 boşluk
            for (int space = 0; space < n - x; space++) {
                System.out.print(" ");
            }
            // Yıldızları yazdır, ilk satırda 1 yıldız, sonra artarak
            for (int star = 1; star <= 2 * x - 1; star++) {
                System.out.print("*");
            }
            // Her satırdan sonra yeni bir satıra geç
            System.out.println();
        }
    }

    }

