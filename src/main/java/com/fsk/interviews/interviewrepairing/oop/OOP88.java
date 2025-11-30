package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 88: Polymorphism ve generic wildcard extreme
 * 
 * Generic wildcard ve polymorphism
 * Upper/lower bounded wildcard
 * Çıktı ne olur?
 */
import java.util.ArrayList;
import java.util.List;

class OOP88A {
    void method(List<? extends OOP88A> list) {
        System.out.println("A method(List<? extends A>)");
        // list.add(new OOP88A()); // HATA! Unknown subtype
        if (!list.isEmpty()) {
            OOP88A obj = list.get(0); // OK
            System.out.println("Got: " + obj.getClass().getSimpleName());
        }
    }
}

class OOP88B extends OOP88A {
    @Override
    void method(List<? extends OOP88A> list) {
        System.out.println("B method(List<? extends A>)");
    }
    
    void method2(List<? super OOP88B> list) {
        System.out.println("B method2(List<? super B>)");
        list.add(new OOP88B()); // OK
        // OOP88B obj = list.get(0); // HATA! Unknown supertype
    }
}

public class OOP88 {
    public static void main(String[] args) {
        List<OOP88A> listA = new ArrayList<>();
        List<OOP88B> listB = new ArrayList<>();
        
        OOP88A obj = new OOP88B();
        obj.method(listA);
        obj.method(listB); // Polymorphism çalışır
        
        OOP88B obj2 = new OOP88B();
        obj2.method2(listA); // OOP88A super OOP88B
        // obj2.method2(listB); // OOP88B super OOP88B değil
    }
}

// ÇIKTI:
// B method(List<? extends A>)
// B method(List<? extends A>)
// B method2(List<? super B>)
// Generic wildcard polymorphism'i etkilemez, override çalışır

