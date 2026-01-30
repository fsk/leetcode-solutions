package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 69: Polymorphism ve return type covariance
 * 
 * Covariant return type ile polymorphism
 * Bridge methods ve type erasure
 * Çıktı ne olur?
 */
class OOP69A {
    Number getValue() {
        System.out.println("A getValue()");
        return 10;
    }
    
    Object getObject() {
        System.out.println("A getObject()");
        return "A";
    }
}

class OOP69B extends OOP69A {
    @Override
    Integer getValue() { // Covariant return type
        System.out.println("B getValue()");
        return 20;
    }
    
    @Override
    String getObject() { // Covariant return type
        System.out.println("B getObject()");
        return "B";
    }
}

class OOP69C extends OOP69B {
    @Override
    Integer getValue() { // Aynı tip
        System.out.println("C getValue()");
        return 30;
    }
    
    // String getObject() zaten var, override edilebilir
}

public class OOP69 {
    public static void main(String[] args) {
        OOP69A obj1 = new OOP69A();
        OOP69A obj2 = new OOP69B();
        OOP69A obj3 = new OOP69C();
        
        Number num1 = obj1.getValue();
        Number num2 = obj2.getValue();
        Number num3 = obj3.getValue();
        
        System.out.println("num1 type: " + num1.getClass().getSimpleName());
        System.out.println("num2 type: " + num2.getClass().getSimpleName());
        System.out.println("num3 type: " + num3.getClass().getSimpleName());
    }
}

// ÇIKTI:
// A getValue()
// B getValue()
// C getValue()
// num1 type: Integer
// num2 type: Integer
// num3 type: Integer
// Covariant return type runtime'da doğru tip döner




