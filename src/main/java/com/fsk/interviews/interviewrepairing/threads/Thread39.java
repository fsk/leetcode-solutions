package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 39: Exchanger kullanımı
 * 
 * Exchanger ile iki thread arasında veri değişimi yapabiliriz.
 * Çıktı ne olur?
 */
import java.util.concurrent.Exchanger;

public class Thread39 {
    private static Exchanger<String> exchanger = new Exchanger<>();
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                String data1 = "Data from Thread 1";
                System.out.println("Thread 1 gönderiyor: " + data1);
                String received = exchanger.exchange(data1);
                System.out.println("Thread 1 aldı: " + received);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000); // Biraz gecikme
                String data2 = "Data from Thread 2";
                System.out.println("Thread 2 gönderiyor: " + data2);
                String received = exchanger.exchange(data2);
                System.out.println("Thread 2 aldı: " + received);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        thread1.start();
        thread2.start();
    }
}

// ÇIKTI:
// Thread 1 gönderiyor: Data from Thread 1
// Thread 2 gönderiyor: Data from Thread 2
// Thread 1 aldı: Data from Thread 2
// Thread 2 aldı: Data from Thread 1
// İki thread verilerini değiş tokuş eder


