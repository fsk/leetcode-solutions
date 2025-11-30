package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 45: Enum ve inheritance trick
 * 
 * Enum'lar final'dır ve extend edilemez.
 * Ama interface implement edebilirler.
 * Çıktı ne olur?
 */
interface OOP45Interface {
    void method();
}

enum OOP45Enum implements OOP45Interface {
    VALUE1 {
        @Override
        public void method() {
            System.out.println("VALUE1 method()");
        }
    },
    VALUE2 {
        @Override
        public void method() {
            System.out.println("VALUE2 method()");
        }
    };
    
    // Abstract method da olabilir
    // abstract void abstractMethod();
}

public class OOP45 {
    public static void main(String[] args) {
        OOP45Enum.VALUE1.method();
        OOP45Enum.VALUE2.method();
        
        OOP45Interface obj = OOP45Enum.VALUE1;
        obj.method();
    }
}

// ÇIKTI:
// VALUE1 method()
// VALUE2 method()
// VALUE1 method()
// Enum'lar interface implement edebilir, her enum constant farklı implementasyon yapabilir


