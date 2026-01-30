package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 8: Static initialization order ve inheritance
 * 
 * Static block'ların çalışma sırası nedir?
 * Inheritance ile nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP8A {
    static int x = getX();
    
    static {
        System.out.println("A static block 1");
    }
    
    static int y = getY();
    
    static {
        System.out.println("A static block 2");
    }
    
    static int getX() {
        System.out.println("A getX()");
        return 10;
    }
    
    static int getY() {
        System.out.println("A getY()");
        return 20;
    }
}

class OOP8B extends OOP8A {
    static int z = getZ();
    
    static {
        System.out.println("B static block");
    }
    
    static int getZ() {
        System.out.println("B getZ()");
        return 30;
    }
}

public class OOP8 {
    static {
        System.out.println("Main static block");
    }
    
    public static void main(String[] args) {
        System.out.println("Main method");
        new OOP8B();
    }
}

// ÇIKTI:
// Main static block
// Main method
// A getX()
// A static block 1
// A getY()
// A static block 2
// B getZ()
// B static block
// Önce parent class static'leri, sonra child class static'leri


