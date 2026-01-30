package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 20: Method overriding ve generic return types
 * 
 * Generic return type ile overriding nasıl çalışır?
 * Type erasure nasıl etkiler?
 * Çıktı ne olur?
 */
class OOP20A {
    Number getNumber() {
        System.out.println("A getNumber()");
        return 10;
    }
}

class OOP20B extends OOP20A {
    @Override
    Integer getNumber() { // Covariant return type
        System.out.println("B getNumber()");
        return 20;
    }
}

class OOP20C<T extends Number> {
    T getValue() {
        System.out.println("C getValue()");
        return null;
    }
}

class OOP20D extends OOP20C<Integer> {
    @Override
    Integer getValue() { // Generic type erasure sonrası Integer
        System.out.println("D getValue()");
        return 30;
    }
}

public class OOP20 {
    public static void main(String[] args) {
        OOP20A obj1 = new OOP20B();
        Number num = obj1.getNumber();
        System.out.println("Type: " + num.getClass().getSimpleName());
        
        OOP20C<Integer> obj2 = new OOP20D();
        Integer val = obj2.getValue();
        System.out.println("Value: " + val);
    }
}

// ÇIKTI:
// B getNumber()
// Type: Integer
// D getValue()
// Value: 30
// Generic type erasure sonrası bridge metodlar oluşturulur
// Covariant return type ile daha spesifik tip dönebiliriz


