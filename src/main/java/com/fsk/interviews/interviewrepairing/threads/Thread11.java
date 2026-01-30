package com.fsk.interviews.interviewrepairing.threads;

/**
 * SORU 11: Thread priority (öncelik)
 * 
 * Thread'lere öncelik verebiliriz (1-10 arası, 5 varsayılan).
 * Çıktı ne olur?
 */
public class Thread11 {
    public static void main(String[] args) {
        Thread lowThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low priority");
            }
        });
        
        Thread highThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("High priority");
            }
        });
        
        lowThread.setPriority(Thread.MIN_PRIORITY); // 1
        highThread.setPriority(Thread.MAX_PRIORITY); // 10
        
        lowThread.start();
        highThread.start();
    }
}

// ÇIKTI:
// "High priority" ve "Low priority" mesajları karışık yazılır
// Öncelik garanti değildir, sadece bir ipucudur
// JVM önceliği göz önünde bulundurur ama garanti etmez


