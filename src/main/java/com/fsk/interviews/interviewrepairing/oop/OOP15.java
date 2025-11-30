package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 15: Constructor ve instance initializer block order
 * 
 * Instance initializer block ve constructor hangi sırada çalışır?
 * Inheritance ile nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP15A {
    {
        System.out.println("A instance block 1");
    }
    
    OOP15A() {
        System.out.println("A constructor");
    }
    
    {
        System.out.println("A instance block 2");
    }
}

class OOP15B extends OOP15A {
    {
        System.out.println("B instance block 1");
    }
    
    OOP15B() {
        super(); // Açıkça yazılmasa da otomatik çağrılır
        System.out.println("B constructor");
    }
    
    {
        System.out.println("B instance block 2");
    }
}

public class OOP15 {
    public static void main(String[] args) {
        new OOP15B();
    }
}

// ÇIKTI:
// A instance block 1
// A instance block 2
// A constructor
// B instance block 1
// B instance block 2
// B constructor
// Instance block'lar constructor'dan önce, sırayla çalışır


