package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 19: Casting ve generic type erasure
 * 
 * Generic type erasure ve casting
 * Unchecked cast warning
 * Çıktı ne olur?
 */
import java.util.List;
import java.util.ArrayList;

public class Basic19 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Raw type
        List rawList = new ArrayList();
        rawList.add("test");
        rawList.add(10);
        
        // Unchecked cast
        List<String> stringList = (List<String>) rawList; // Warning!
        System.out.println("stringList: " + stringList);
        
        // Runtime type erasure
        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        
        System.out.println("intList class: " + intList.getClass());
        System.out.println("strList class: " + strList.getClass());
        System.out.println("Same class? " + (intList.getClass() == strList.getClass()));
        
        // Cast to Object
        Object obj = intList;
        @SuppressWarnings("unchecked")
        List<Integer> castBack = (List<Integer>) obj;
        System.out.println("Cast back: " + castBack);
        
        // Invalid cast - compile error (Java 5+)
        // List<String> invalid = (List<String>) intList; // HATA! Compile error
        // Type erasure nedeniyle runtime'da kontrol edilemez ama compile-time'da hata verir
        
        // Raw type cast - warning
        @SuppressWarnings("unchecked")
        List<String> invalid = (List<String>) (List<?>) intList; // Raw type üzerinden
        System.out.println("Invalid cast (via raw): " + invalid);
    }
}

// ÇIKTI:
// stringList: [test, 10]
// intList class: class java.util.ArrayList
// strList class: class java.util.ArrayList
// Same class? true
// Cast back: []
// Exception: (runtime'da sorun olmayabilir, type erasure nedeniyle)
// Generic type erasure nedeniyle casting runtime'da kontrol edilemez
// Unchecked cast warning verilir

