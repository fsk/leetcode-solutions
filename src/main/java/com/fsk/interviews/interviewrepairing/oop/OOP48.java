package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 48: Method overriding ve bridge methods
 * 
 * Bridge methods nedir?
 * Type erasure ile nasıl ilgilidir?
 * Çıktı ne olur?
 */
class OOP48A {
    Number getValue() {
        return 10;
    }
}

class OOP48B extends OOP48A {
    @Override
    Integer getValue() { // Covariant return type
        return 20;
    }
}

public class OOP48 {
    public static void main(String[] args) {
        OOP48A obj = new OOP48B();
        Number num = obj.getValue();
        System.out.println("Type: " + num.getClass().getSimpleName());
        System.out.println("Value: " + num);
    }
}

// ÇIKTI:
// Type: Integer
// Value: 20
// Bridge method: Compiler tarafından oluşturulan, type erasure için gerekli metod
// Covariant return type için bridge method oluşturulur


