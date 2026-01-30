package com.fsk.denemeler.threaddenemeler.racecondition;


/**
 * -- RACE CONDITION --
 * Iki farkli thread ayni anda ayni degiskene erisir ve degiskeni degistirir.
 * Bu durumda degiskenin degeri belirlenemez.
 * Bu durumda race condition olur.
 * Bu durumda thread1 ve thread2 ayni anda counter'i 10 artirir ve counter'in degeri 20 olur.
 * Sayilarin siralari garanti edilmez.
 * 1 - 20 arasindaki bazi sayilar atlanabilir.
 * Cevap tesadufen 20 olabilir. Ama bu tamamen tesadufen olur.
 */

public class Main1 {

    public static int counter = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                counter++;
                System.out.println("thread1 " + counter);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                counter++;
                System.out.println("thread2 " + counter);
            }
        });


        thread1.start();
        thread2.start();

    }

}
