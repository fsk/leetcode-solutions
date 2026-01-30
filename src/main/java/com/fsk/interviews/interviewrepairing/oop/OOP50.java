package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 50: Complex inheritance ve method resolution
 * 
 * Çok katmanlı inheritance'da method resolution nasıl çalışır?
 * Diamond problem class'larda nasıl çözülür?
 * Çıktı ne olur?
 */
class OOP50A {
    void method() {
        System.out.println("A method()");
    }
}

class OOP50B extends OOP50A {
    @Override
    void method() {
        System.out.println("B method()");
    }
}

class OOP50C extends OOP50A {
    @Override
    void method() {
        System.out.println("C method()");
    }
}

// Java multiple inheritance desteklemez, bu yüzden bu kod compile olmaz
// class OOP50D extends OOP50B, OOP50C { } // HATA!

class OOP50D extends OOP50B {
    // OOP50B'den method() inherit edilir
    // OOP50C'ye erişim yok
}

public class OOP50 {
    public static void main(String[] args) {
        OOP50A obj1 = new OOP50A();
        OOP50A obj2 = new OOP50B();
        OOP50A obj3 = new OOP50C();
        OOP50A obj4 = new OOP50D();
        
        obj1.method();
        obj2.method();
        obj3.method();
        obj4.method();
    }
}

// ÇIKTI:
// A method()
// B method()
// C method()
// B method()
// Java'da multiple inheritance yok, bu yüzden diamond problem oluşmaz
// Her class tek bir parent'tan extend eder, method resolution basittir




