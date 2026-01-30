package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 15: Thread.isAlive() kontrolü
 * 
 * isAlive() ile thread'in hala çalışıp çalışmadığını kontrol edebiliriz.
 * Çıktı ne olur?
 */
public class Thread15 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        System.out.println("1. isAlive: " + thread.isAlive()); // false
        thread.start();
        System.out.println("2. isAlive: " + thread.isAlive()); // true
        
        try {
            Thread.sleep(100);
            System.out.println("3. isAlive: " + thread.isAlive()); // true
            thread.join();
            System.out.println("4. isAlive: " + thread.isAlive()); // false
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// 1. isAlive: false
// 2. isAlive: true
// 3. isAlive: true
// 4. isAlive: false


