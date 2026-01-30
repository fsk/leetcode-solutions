package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 38: Marker interface ve functional interface
 * 
 * Marker interface nedir?
 * Functional interface ile farkı nedir?
 * Çıktı ne olur?
 */
// Marker interface - hiç metod yok
interface OOP38Serializable {
    // Boş interface
}

// Functional interface - tek abstract metod
@FunctionalInterface
interface OOP38Runnable {
    void run();
}

// Normal interface
interface OOP38Normal {
    void method1();
    void method2();
}

class OOP38Test implements OOP38Serializable, OOP38Runnable {
    @Override
    public void run() {
        System.out.println("Running");
    }
}

public class OOP38 {
    public static void main(String[] args) {
        OOP38Test obj = new OOP38Test();
        
        if (obj instanceof OOP38Serializable) {
            System.out.println("Is serializable");
        }
        
        OOP38Runnable runnable = obj::run;
        runnable.run();
    }
}

// ÇIKTI:
// Is serializable
// Running
// Marker interface hiç metod içermez, type checking için kullanılır
// Functional interface tek abstract metod içerir, lambda ile kullanılır




