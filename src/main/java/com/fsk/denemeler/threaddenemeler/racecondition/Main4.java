package com.fsk.denemeler.threaddenemeler.racecondition;

public class Main4 {

    public static int counter = 0;
    public static Object lock = new Object();
    
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: " + counter);
                synchronized (lock) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    counter++;
                }
                System.out.println("Thread 2: " + counter);
            }
        });

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter);
    }
}