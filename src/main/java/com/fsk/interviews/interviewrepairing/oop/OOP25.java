package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 25: Interface inheritance ve default method conflict
 * 
 * Interface'ler birbirini extend edebilir.
 * Default method conflict nasıl çözülür?
 * Çıktı ne olur?
 */
interface OOP25A {
    default void method() {
        System.out.println("A method()");
    }
}

interface OOP25B extends OOP25A {
    default void method() {
        System.out.println("B method()");
    }
}

interface OOP25C extends OOP25A {
    // method() override etmez, A'nın metodunu kullanır
}

interface OOP25D extends OOP25B, OOP25C {
    // Diamond problem! B ve C'den method() geliyor
    // B method() override etmiş, C etmemiş
    // Çözüm: En spesifik olan (B) kazanır
}

class OOP25E implements OOP25D {
    // method() override edilebilir ama zorunlu değil
}

public class OOP25 {
    public static void main(String[] args) {
        OOP25E obj = new OOP25E();
        obj.method(); // Hangi metod?
    }
}

// ÇIKTI:
// B method()
// En spesifik override eden interface'in metodu kullanılır
// B method() override etmiş, C etmemiş, bu yüzden B'nin metodu kullanılır


