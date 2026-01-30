package com.fsk.denemeler.threaddenemeler.racecondition;

/**
 * -- SYNCHRONIZED METHOD --
 * Synchronized method ile race condition'i onler.
 * Synchronized method ile degiskenin erisimini sinirlayarak race condition'i onler.
 * Ama siralama garanti edilmez.
 * increment methodu synchronized oldugu icin thread1 ve thread2 ayni anda erisemez.
 * increment methodu aynı anda sadece 1 thread tarafından çalıştırılabilir
 * diger thread iceri girmek istediginde monitor lock'a takilir ve bekler.
 * memory visibility garanti edilir.
 */


public class Main2 {

    public static int counter = 0;

    public synchronized static int increment() {
        return counter++;
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1 ==> " + Main2.increment());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2 ==> " + Main2.increment());
            }
        });

        t1.start();
        t2.start();

    }
}
