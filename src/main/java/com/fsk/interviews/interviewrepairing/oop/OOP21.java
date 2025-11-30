package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 21: Polymorphism ve field access
 * 
 * Field'lar override edilmez, hide edilir.
 * Polymorphism field'lar için geçerli değildir.
 * Çıktı ne olur?
 */
class OOP21A {
    String name = "A";
    
    String getName() {
        return name;
    }
}

class OOP21B extends OOP21A {
    String name = "B"; // Hide
    
    @Override
    String getName() {
        return name;
    }
}

public class OOP21 {
    public static void main(String[] args) {
        OOP21A obj1 = new OOP21A();
        OOP21A obj2 = new OOP21B();
        OOP21B obj3 = new OOP21B();
        
        System.out.println("obj1.name = " + obj1.name);
        System.out.println("obj2.name = " + obj2.name); // Trick!
        System.out.println("obj3.name = " + obj3.name);
        
        System.out.println("obj1.getName() = " + obj1.getName());
        System.out.println("obj2.getName() = " + obj2.getName()); // Trick!
        System.out.println("obj3.getName() = " + obj3.getName());
    }
}

// ÇIKTI:
// obj1.name = A
// obj2.name = A (compile-time tip önemli - field hiding)
// obj3.name = B
// obj1.getName() = A
// obj2.getName() = B (runtime tip önemli - method overriding)
// obj3.getName() = B
// Field'lar için polymorphism yok, metodlar için var


