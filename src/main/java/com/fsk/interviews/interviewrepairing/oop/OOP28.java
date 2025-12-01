package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 28: Anonymous class ve final variable access
 * 
 * Anonymous class local variable'lara nasıl erişir?
 * Final olmayan variable'lara erişilebilir mi?
 * Çıktı ne olur?
 */
interface OOP28Interface {
    void method();
}

public class OOP28 {
    public static void main(String[] args) {
        final int finalVar = 10;
        int effectivelyFinal = 20;
        int nonFinal = 30;
        nonFinal = 40; // Değiştirildi
        
        OOP28Interface obj = new OOP28Interface() {
            @Override
            public void method() {
                System.out.println("finalVar = " + finalVar);
                System.out.println("effectivelyFinal = " + effectivelyFinal);
                // System.out.println("nonFinal = " + nonFinal); // HATA! Final değil
            }
        };
        
        obj.method();
    }
}

// ÇIKTI:
// finalVar = 10
// effectivelyFinal = 20
// Anonymous class sadece final veya effectively final variable'lara erişebilir
// Effectively final: Değeri hiç değiştirilmemiş variable




