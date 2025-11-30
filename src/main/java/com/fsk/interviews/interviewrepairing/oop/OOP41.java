package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 41: Generics ve type erasure trick
 * 
 * Type erasure nedir?
 * Runtime'da generic type bilgisi kaybolur mu?
 * Çıktı ne olur?
 */
import java.util.ArrayList;
import java.util.List;

class OOP41Test {
    <T> void method(List<T> list) {
        System.out.println("Generic method: " + list.getClass().getSimpleName());
    }
    
    void method2(List<String> list) {
        System.out.println("String list");
    }
    
    // void method2(List<Integer> list) { } // HATA! Type erasure sonrası aynı signature
}

public class OOP41 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        
        OOP41Test test = new OOP41Test();
        test.method(stringList);
        test.method(intList);
        
        // Runtime'da type bilgisi kaybolur
        System.out.println("stringList class: " + stringList.getClass());
        System.out.println("intList class: " + intList.getClass());
        System.out.println("Same class? " + (stringList.getClass() == intList.getClass()));
    }
}

// ÇIKTI:
// Generic method: ArrayList
// Generic method: ArrayList
// stringList class: class java.util.ArrayList
// intList class: class java.util.ArrayList
// Same class? true
// Type erasure: Generic type bilgisi compile-time'da kaybolur, runtime'da yoktur


