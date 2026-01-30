package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 19: Method overriding ve synchronized keyword
 * 
 * Override edilen metod synchronized olabilir mi?
 * Parent synchronized ise child da olmalı mı?
 * Çıktı ne olur?
 */
class OOP19A {
    synchronized void method() {
        System.out.println("A synchronized method()");
    }
    
    void method2() {
        System.out.println("A method2()");
    }
}

class OOP19B extends OOP19A {
    @Override
    void method() { // synchronized keyword inherit edilmez
        System.out.println("B method() - synchronized değil!");
    }
    
    @Override
    synchronized void method2() { // synchronized eklenebilir
        System.out.println("B synchronized method2()");
    }
}

public class OOP19 {
    public static void main(String[] args) {
        OOP19B obj = new OOP19B();
        obj.method(); // Synchronized değil!
        obj.method2(); // Synchronized
    }
}

// ÇIKTI:
// B method() - synchronized değil!
// B synchronized method2()
// synchronized keyword metodun bir parçası değil, override edilmez
// Override ederken synchronized eklenebilir veya kaldırılabilir


