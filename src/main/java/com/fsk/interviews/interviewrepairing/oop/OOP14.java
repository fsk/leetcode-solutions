package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 14: Final method ve private method overriding
 * 
 * Final metodlar override edilebilir mi?
 * Private metodlar final mıdır?
 * Çıktı ne olur?
 */
class OOP14A {
    final void finalMethod() {
        System.out.println("A finalMethod()");
    }
    
    private void privateMethod() {
        System.out.println("A privateMethod()");
    }
    
    public void publicMethod() {
        privateMethod();
    }
}

class OOP14B extends OOP14A {
    // void finalMethod() { } // HATA! Final metod override edilemez
    
    private void privateMethod() { // Bu override değil, yeni bir metod
        System.out.println("B privateMethod()");
    }
    
    @Override
    public void publicMethod() {
        System.out.println("B publicMethod()");
        privateMethod(); // B'nin kendi private metodunu çağırır
        super.publicMethod(); // A'nın public metodunu çağırır
    }
}

public class OOP14 {
    public static void main(String[] args) {
        OOP14B obj = new OOP14B();
        obj.publicMethod();
        obj.finalMethod(); // Final metod inherit edilir
    }
}

// ÇIKTI:
// B publicMethod()
// B privateMethod()
// A privateMethod()
// B finalMethod()
// Final metodlar override edilemez ama inherit edilir
// Private metodlar zaten override edilemez (görünür değiller)


