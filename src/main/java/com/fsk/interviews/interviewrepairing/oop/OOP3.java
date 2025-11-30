package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 3: Method overloading ve varargs trick
 * 
 * Varargs ve normal parametre arasında method overloading nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP3Test {
    void method(int... args) {
        System.out.println("Varargs method: " + args.length);
    }
    
    void method(int a, int b) {
        System.out.println("Two ints: " + a + ", " + b);
    }
    
    void method(int a, int b, int c) {
        System.out.println("Three ints: " + a + ", " + b + ", " + c);
    }
}

public class OOP3 {
    public static void main(String[] args) {
        OOP3Test test = new OOP3Test();
        test.method(1);
        test.method(1, 2);
        test.method(1, 2, 3);
        test.method(1, 2, 3, 4);
    }
}

// ÇIKTI:
// Varargs method: 1 (en spesifik yok, varargs kullanılır)
// Two ints: 1, 2 (en spesifik)
// Three ints: 1, 2, 3 (en spesifik)
// Varargs method: 4 (en spesifik yok, varargs kullanılır)


