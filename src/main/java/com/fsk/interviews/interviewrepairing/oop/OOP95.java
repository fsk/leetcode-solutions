package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 95: Polymorphism ve array covariance extreme
 * 
 * Array covariance tehlikesi
 * Runtime type checking
 * Çıktı ne olur?
 */
class OOP95A {
    void method() {
        System.out.println("A method()");
    }
}

class OOP95B extends OOP95A {
    @Override
    void method() {
        System.out.println("B method()");
    }
}

class OOP95C extends OOP95A {
    @Override
    void method() {
        System.out.println("C method()");
    }
}

public class OOP95 {
    public static void main(String[] args) {
        OOP95B[] arrayB = new OOP95B[3];
        arrayB[0] = new OOP95B();
        arrayB[1] = new OOP95B();
        
        // Array covariance
        OOP95A[] arrayA = arrayB; // Compile-time OK
        
        // ArrayStoreException riski!
        try {
            arrayA[2] = new OOP95C(); // Runtime error!
        } catch (ArrayStoreException e) {
            System.out.println("ArrayStoreException: " + e.getMessage());
        }
        
        // Polymorphism çalışır
        for (OOP95A obj : arrayA) {
            if (obj != null) {
                obj.method();
            }
        }
    }
}

// ÇIKTI:
// ArrayStoreException: ...
// B method()
// B method()
// Array covariance tehlikeli, runtime type checking yapılır
// Polymorphism array element'lerinde çalışır


