package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 10: Exception handling ve method overriding
 * 
 * Override edilen metod exception fırlatabilir mi?
 * Checked vs unchecked exception farkı nedir?
 * Çıktı ne olur?
 */
import java.io.IOException;

class OOP10A {
    void method() throws IOException {
        System.out.println("A method()");
        throw new IOException("A exception");
    }
    
    void method2() throws RuntimeException {
        System.out.println("A method2()");
    }
}

class OOP10B extends OOP10A {
    @Override
    void method() throws IOException { // Aynı veya daha spesifik exception
        System.out.println("B method()");
    }
    
    // void method() throws Exception { // HATA! Daha genel exception olamaz
    
    @Override
    void method2() throws RuntimeException { // Unchecked exception, sorun yok
        System.out.println("B method2()");
        throw new RuntimeException("B exception");
    }
}

public class OOP10 {
    public static void main(String[] args) {
        OOP10B obj = new OOP10B();
        try {
            obj.method();
        } catch (IOException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        
        obj.method2(); // Unchecked exception, catch zorunlu değil
    }
}

// ÇIKTI:
// B method()
// B method2()
// Override edilen metod aynı veya daha spesifik exception fırlatabilir
// Daha genel exception fırlatamaz (checked exception için)




