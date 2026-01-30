package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 9: Covariant return types
 * 
 * Override edilen metodun return type'ı değiştirilebilir mi?
 * Covariant return type nedir?
 * Çıktı ne olur?
 */
class OOP9A {
    OOP9A getInstance() {
        System.out.println("A getInstance()");
        return new OOP9A();
    }
    
    Number getNumber() {
        System.out.println("A getNumber()");
        return 10;
    }
}

class OOP9B extends OOP9A {
    @Override
    OOP9B getInstance() { // Covariant return type - OOP9A'nın subclass'ı
        System.out.println("B getInstance()");
        return new OOP9B();
    }
    
    @Override
    Integer getNumber() { // Covariant return type - Number'ın subclass'ı
        System.out.println("B getNumber()");
        return 20;
    }
}

public class OOP9 {
    public static void main(String[] args) {
        OOP9A obj = new OOP9B();
        OOP9A instance = obj.getInstance(); // Return type ne?
        Number num = obj.getNumber(); // Return type ne?
        
        System.out.println("Instance type: " + instance.getClass().getSimpleName());
        System.out.println("Number type: " + num.getClass().getSimpleName());
    }
}

// ÇIKTI:
// B getInstance()
// B getNumber()
// Instance type: OOP9B (runtime'da OOP9B döner)
// Number type: Integer (runtime'da Integer döner)
// Covariant return type: Override edilen metod daha spesifik tip dönebilir


