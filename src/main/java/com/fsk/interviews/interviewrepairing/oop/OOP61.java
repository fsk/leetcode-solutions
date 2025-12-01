package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 61: Polymorphism ve field hiding extreme case
 * 
 * Field hiding'de compile-time vs runtime tip farkı
 * Nested inheritance'da nasıl çalışır?
 * Çıktı ne olur?
 */
class OOP61A {
    String name = "A";
    int value = 1;
    
    String getName() {
        return name;
    }
    
    int getValue() {
        return value;
    }
}

class OOP61B extends OOP61A {
    String name = "B"; // Hide
    int value = 2; // Hide
    
    @Override
    String getName() {
        return name;
    }
    
    @Override
    int getValue() {
        return value;
    }
}

class OOP61C extends OOP61B {
    String name = "C"; // Hide
    int value = 3; // Hide
}

public class OOP61 {
    public static void main(String[] args) {
        OOP61A obj1 = new OOP61A();
        OOP61A obj2 = new OOP61B();
        OOP61A obj3 = new OOP61C();
        
        System.out.println("obj1.name = " + obj1.name + ", getName() = " + obj1.getName());
        System.out.println("obj2.name = " + obj2.name + ", getName() = " + obj2.getName());
        System.out.println("obj3.name = " + obj3.name + ", getName() = " + obj3.getName());
        
        System.out.println("obj1.value = " + obj1.value + ", getValue() = " + obj1.getValue());
        System.out.println("obj2.value = " + obj2.value + ", getValue() = " + obj2.getValue());
        System.out.println("obj3.value = " + obj3.value + ", getValue() = " + obj3.getValue());
    }
}

// ÇIKTI:
// obj1.name = A, getName() = A
// obj2.name = A, getName() = B (field compile-time, method runtime)
// obj3.name = A, getName() = C
// obj1.value = 1, getValue() = 1
// obj2.value = 1, getValue() = 2
// obj3.value = 1, getValue() = 3
// Field'lar compile-time tip'e göre, metodlar runtime tip'e göre çalışır




