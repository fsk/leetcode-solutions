package com.fsk.denemeler.threaddenemeler.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class Main3 {
    

    public static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: " + counter.incrementAndGet());
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2: " + counter.incrementAndGet());
            }
        });
        thread1.start();
        thread2.start();


    }

}
