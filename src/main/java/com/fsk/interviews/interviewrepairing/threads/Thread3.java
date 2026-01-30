package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 3: Lambda expression ile thread oluşturma
 * 
 * Lambda expression kullanarak daha kısa bir şekilde thread oluşturuyoruz.
 * Çıktı ne olur?
 */
public class Thread3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Lambda thread is running");
        });
        thread.start();
        System.out.println("Main thread is running");
    }
}

// ÇIKTI:
// "Main thread" veya "Lambda thread çalışıyor" önce yazılabilir
// Her ikisi de yazılır

