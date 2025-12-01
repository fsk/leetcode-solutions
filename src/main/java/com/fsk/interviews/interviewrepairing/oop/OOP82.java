package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 82: Polymorphism ve array trick
 * 
 * Array polymorphism nasıl çalışır?
 * Array element polymorphism
 * Çıktı ne olur?
 */
class OOP82A {
    void method() {
        System.out.println("A method()");
    }
}

class OOP82B extends OOP82A {
    @Override
    void method() {
        System.out.println("B method()");
    }
}

class OOP82C extends OOP82B {
    @Override
    void method() {
        System.out.println("C method()");
    }
}

public class OOP82 {
    public static void main(String[] args) {
        OOP82A[] array = new OOP82A[5];
        array[0] = new OOP82A();
        array[1] = new OOP82B();
        array[2] = new OOP82C();
        array[3] = null;
        
        for (OOP82A obj : array) {
            if (obj != null) {
                obj.method(); // Polymorphism çalışır
            }
        }
        
        // Array type covariance
        OOP82B[] arrayB = new OOP82B[3];
        arrayB[0] = new OOP82B();
        arrayB[1] = new OOP82C();
        
        // OOP82A[] arrayA = arrayB; // ArrayStoreException riski!
        OOP82A[] arrayA = arrayB; // Compile-time OK, runtime risk
        // arrayA[0] = new OOP82A(); // ArrayStoreException!
    }
}

// ÇIKTI:
// A method()
// B method()
// C method()
// Array element'lerinde polymorphism çalışır
// Array type covariance tehlikeli olabilir




