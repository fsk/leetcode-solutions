package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 49: Initialization order ve circular dependency
 * 
 * Circular dependency initialization'da ne olur?
 * Static ve instance initialization sırası nedir?
 * Çıktı ne olur?
 */
class OOP49A {
    static int x = OOP49B.getValue();
    
    static int getValue() {
        System.out.println("A getValue()");
        return 10;
    }
}

class OOP49B {
    static int y = OOP49A.getValue();
    
    static int getValue() {
        System.out.println("B getValue()");
        return 20;
    }
}

public class OOP49 {
    static {
        System.out.println("Main static block");
    }
    
    public static void main(String[] args) {
        System.out.println("OOP49A.x = " + OOP49A.x);
        System.out.println("OOP49B.y = " + OOP49B.y);
    }
}

// ÇIKTI:
// Main static block
// B getValue() (OOP49A.x initialize edilirken)
// A getValue() (OOP49B.y initialize edilirken)
// OOP49A.x = 20
// OOP49B.y = 10
// Circular dependency initialization sırasında çözülür, her class bir kez initialize edilir




