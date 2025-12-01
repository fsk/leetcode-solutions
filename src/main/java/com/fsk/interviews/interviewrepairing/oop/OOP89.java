package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 89: Null ve initialization extreme case
 * 
 * Null field initialization
 * Final field null
 * Çıktı ne olur?
 */
class OOP89A {
    String name = null;
    final String finalName = null; // Final null olabilir
    static String staticName = null;
    
    OOP89A() {
        System.out.println("A constructor");
        System.out.println("name == null: " + (name == null));
        System.out.println("finalName == null: " + (finalName == null));
    }
    
    void method() {
        if (name != null) {
            System.out.println("name.length() = " + name.length());
        } else {
            System.out.println("name is null");
        }
    }
}

class OOP89B extends OOP89A {
    String name = null; // Hide, null olabilir
    
    OOP89B() {
        System.out.println("B constructor");
        System.out.println("name == null: " + (name == null));
    }
    
    @Override
    void method() {
        super.method();
        if (name != null) {
            System.out.println("B name.length() = " + name.length());
        } else {
            System.out.println("B name is null");
        }
    }
}

public class OOP89 {
    public static void main(String[] args) {
        OOP89B obj = new OOP89B();
        obj.method();
    }
}

// ÇIKTI:
// A constructor
// name == null: true
// finalName == null: true
// B constructor
// name == null: true
// name is null
// B name is null
// Null field initialization mümkün, null check gerekli




