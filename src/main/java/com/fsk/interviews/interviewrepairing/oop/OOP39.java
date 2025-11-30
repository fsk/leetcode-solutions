package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 39: Interface ve multiple inheritance simulation
 * 
 * Interface ile multiple inheritance nasıl simüle edilir?
 * Diamond problem nasıl çözülür?
 * Çıktı ne olur?
 */
interface OOP39A {
    default void method() {
        System.out.println("A method()");
    }
}

interface OOP39B extends OOP39A {
    default void method() {
        System.out.println("B method()");
    }
}

interface OOP39C extends OOP39A {
    // method() override etmez
}

interface OOP39D extends OOP39B, OOP39C {
    // Diamond problem: B ve C'den method() geliyor
    // B override etmiş, C etmemiş
    // En spesifik olan (B) kazanır
}

class OOP39E implements OOP39D {
    // method() override edilebilir ama zorunlu değil
    @Override
    public void method() {
        // OOP39B.super.method(); // Illegal! OOP39D üzerinden erişilemez
        System.out.println("E method() - B'nin metodu kullanılır (en spesifik)");
    }
}

public class OOP39 {
    public static void main(String[] args) {
        OOP39E obj = new OOP39E();
        obj.method();
    }
}

// ÇIKTI:
// B method()
// E method()
// Interface multiple inheritance diamond problem'i en spesifik override ile çözülür

