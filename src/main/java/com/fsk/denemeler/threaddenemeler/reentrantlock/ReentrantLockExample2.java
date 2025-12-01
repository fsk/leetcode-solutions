package com.fsk.denemeler.threaddenemeler.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ÖRNEK 2: Birden Fazla Metodda Lock Kullanımı
 * 
 * Aynı lock'u farklı metodlarda kullanarak thread-safe işlemler yapma.
 */
public class ReentrantLockExample2 {
    private static int balance = 1000;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposit: +" + amount + ", Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public static void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdraw: -" + amount + ", Balance: " + balance);
            } else {
                System.out.println("Insufficient balance!");
            }
        } finally {
            lock.unlock();
        }
    }

    public static int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                deposit(100);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                withdraw(50);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

        System.out.println("Final balance: " + getBalance());
    }
}

