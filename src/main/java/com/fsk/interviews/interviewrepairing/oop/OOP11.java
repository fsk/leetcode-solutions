package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 11: Method hiding ve instance variable hiding
 * 
 * Static metodlar hide edilir, instance variable'lar da hide edilir.
 * Çıktı ne olur?
 */
class OOP11A {
    static int x = 10;
    int y = 20;
    
    static void staticMethod() {
        System.out.println("A staticMethod, x = " + x);
    }
    
    void instanceMethod() {
        System.out.println("A instanceMethod, y = " + y);
    }
}

class OOP11B extends OOP11A {
    static int x = 30; // Hide
    int y = 40; // Hide
    
    static void staticMethod() { // Hide
        System.out.println("B staticMethod, x = " + x);
    }
    
    @Override
    void instanceMethod() { // Override
        System.out.println("B instanceMethod, y = " + y);
    }
}

public class OOP11 {
    public static void main(String[] args) {
        OOP11A obj1 = new OOP11A();
        OOP11A obj2 = new OOP11B();
        OOP11B obj3 = new OOP11B();
        
        System.out.println("obj1.x = " + obj1.x + ", obj1.y = " + obj1.y);
        System.out.println("obj2.x = " + obj2.x + ", obj2.y = " + obj2.y); // Trick!
        System.out.println("obj3.x = " + obj3.x + ", obj3.y = " + obj3.y);
        
        obj1.staticMethod();
        obj2.staticMethod(); // Trick!
        obj3.staticMethod();
        
        obj1.instanceMethod();
        obj2.instanceMethod(); // Trick!
        obj3.instanceMethod();
    }
}

// ÇIKTI:
// obj1.x = 10, obj1.y = 20
// obj2.x = 10, obj2.y = 20 (compile-time tip önemli - hiding)
// obj3.x = 30, obj3.y = 40
// A staticMethod, x = 10
// A staticMethod, x = 10 (compile-time tip)
// B staticMethod, x = 30
// A instanceMethod, y = 20
// B instanceMethod, y = 40 (runtime tip)
// B instanceMethod, y = 40


