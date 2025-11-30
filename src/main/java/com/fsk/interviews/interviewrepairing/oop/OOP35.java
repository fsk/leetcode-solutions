package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 35: Abstract class ve final metod
 * 
 * Abstract class'ta final metod olabilir mi?
 * Final abstract metod olabilir mi?
 * Çıktı ne olur?
 */
abstract class OOP35A {
    final void finalMethod() {
        System.out.println("A finalMethod()");
    }
    
    abstract void abstractMethod();
    
    // final abstract void method(); // HATA! Final abstract olamaz
}

class OOP35B extends OOP35A {
    // void finalMethod() { } // HATA! Final metod override edilemez
    
    @Override
    void abstractMethod() {
        System.out.println("B abstractMethod()");
    }
}

public class OOP35 {
    public static void main(String[] args) {
        OOP35B obj = new OOP35B();
        obj.finalMethod(); // Inherit edilir
        obj.abstractMethod();
    }
}

// ÇIKTI:
// A finalMethod()
// B abstractMethod()
// Abstract class'ta final metod olabilir ama final abstract olamaz


