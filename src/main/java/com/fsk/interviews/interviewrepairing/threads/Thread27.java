package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 27: volatile keyword kullanımı
 * 
 * volatile ile değişkenin her zaman memory'den okunmasını garanti ederiz.
 * Çıktı ne olur?
 */
public class Thread27 {
    private static volatile boolean flag = true;
    
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (flag) {
                // volatile olmasaydı, flag değeri cache'den okunabilirdi
                // ve sonsuz döngüye girebilirdi
            }
            System.out.println("Thread durdu");
        });
        
        thread.start();
        
        try {
            Thread.sleep(1000);
            flag = false; // volatile sayesinde thread bu değişikliği görür
            System.out.println("Flag false yapıldı");
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ÇIKTI:
// (1 saniye bekler)
// Flag false yapıldı
// Thread durdu
// volatile olmasaydı, thread flag değişikliğini görmeyebilirdi


