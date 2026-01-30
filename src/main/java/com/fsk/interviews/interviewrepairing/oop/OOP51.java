package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 51: Null reference ve method call
 * 
 * Null reference üzerinden metod çağrılabilir mi?
 * Static metod null üzerinden çağrılabilir mi?
 * Çıktı ne olur?
 */
class OOP51Test {
    static void staticMethod() {
        System.out.println("Static method called");
    }
    
    void instanceMethod() {
        System.out.println("Instance method called");
    }
}

public class OOP51 {
    public static void main(String[] args) {
        OOP51Test obj = null;
        
        obj.staticMethod(); // Null üzerinden static metod çağrılabilir!
        // obj.instanceMethod(); // NullPointerException!
        
        System.out.println("obj == null: " + (obj == null));
    }
}

// ÇIKTI:
// Static method called
// obj == null: true
// Static metodlar null reference üzerinden çağrılabilir (derleyici uyarı verir ama çalışır)
// Instance metodlar null üzerinden çağrılamaz (NullPointerException)


