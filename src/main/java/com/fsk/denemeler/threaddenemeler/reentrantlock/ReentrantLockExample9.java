package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 9: Producer-Consumer Pattern
 * 
 * ReentrantLock ve Condition kullanarak klasik producer-consumer problemi.
 * Buffer doluyken producer bekler, boşken consumer bekler.
 */
public class ReentrantLockExample9 {
    private static final int CAPACITY = 5;
    private static final Queue<Integer> buffer = new LinkedList<>();
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();

    public static void producer() {
        for (int i = 1; i <= 10; i++) {
            lock.lock();
            try {
                while (buffer.size() == CAPACITY) {
                    System.out.println("Producer: Buffer dolu, bekleniyor...");
                    notFull.await();
                }
                buffer.offer(i);
                System.out.println("Producer: Üretildi: " + i + " (Buffer size: " + buffer.size() + ")");
                notEmpty.signal(); // Consumer'ı uyandır
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void consumer() {
        for (int i = 1; i <= 10; i++) {
            lock.lock();
            try {
                while (buffer.isEmpty()) {
                    System.out.println("Consumer: Buffer boş, bekleniyor...");
                    notEmpty.await();
                }
                int value = buffer.poll();
                System.out.println("Consumer: Tüketildi: " + value + " (Buffer size: " + buffer.size() + ")");
                notFull.signal(); // Producer'ı uyandır
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> producer());
        Thread consumerThread = new Thread(() -> consumer());

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tüm işlemler tamamlandı!");
    }
}



