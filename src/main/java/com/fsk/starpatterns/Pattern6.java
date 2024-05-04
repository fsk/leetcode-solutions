package com.fsk.starpatterns;

public class Pattern6 {

    public static void main(String[] args) {

        int n = 5;

        for (int x = 1; x <= n; x++) {
            // Her satır için boşlukları yazdır, ilk satırda 0 boşluk
            for (int space = 0; space < x - 1; space++) {
                System.out.print(" ");
            }
            // Yıldızları yazdır, ilk satırda 7 yıldız, sonra azalarak
            for (int star = 0; star < 2 * (n - x) + 1; star++) {
                System.out.print("*");
            }
            // Her satırdan sonra yeni bir satıra geç
            System.out.println();
        }
    }
}
