package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 40: Interface constant ve enum
 * 
 * Interface'de enum tanımlanabilir mi?
 * Constant ve enum arasındaki fark nedir?
 * Çıktı ne olur?
 */
interface OOP40A {
    int VALUE = 10;
    
    enum Color {
        RED, GREEN, BLUE
    }
    
    interface Nested {
        int NESTED_VALUE = 20;
    }
}

class OOP40B implements OOP40A {
    // Interface constant'ları inherit eder
}

public class OOP40 {
    public static void main(String[] args) {
        System.out.println("OOP40A.VALUE = " + OOP40A.VALUE);
        System.out.println("OOP40B.VALUE = " + OOP40B.VALUE);
        
        System.out.println("Color.RED = " + OOP40A.Color.RED);
        
        System.out.println("Nested.NESTED_VALUE = " + OOP40A.Nested.NESTED_VALUE);
        
        OOP40B obj = new OOP40B();
        // obj.VALUE; // Ambiguous olabilir
    }
}

// ÇIKTI:
// OOP40A.VALUE = 10
// OOP40B.VALUE = 10
// Color.RED = RED
// Nested.NESTED_VALUE = 20
// Interface'de enum ve nested interface tanımlanabilir


