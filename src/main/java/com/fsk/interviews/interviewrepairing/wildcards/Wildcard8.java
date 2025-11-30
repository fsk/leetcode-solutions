package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 8: Wildcard ve null
 * 
 * Wildcard ile null eklenebilir mi?
 * Çıktı ne olur?
 */
public class Wildcard8 {
    public static void addNull(List<?> list) {
        // list.add(null); // HATA! Unbounded wildcard'a null eklenemez
        // list.add(new Object()); // HATA! Unknown type
    }
    
    public static void addNullExtends(List<? extends Number> list) {
        // list.add(null); // HATA! Upper bounded wildcard'a null eklenemez
    }
    
    public static void addNullSuper(List<? super Integer> list) {
        list.add(null); // OK! Lower bounded wildcard'a null eklenebilir
        System.out.println("Null added to list");
    }
    
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        addNullSuper(intList);
        System.out.println("List: " + intList);
    }
}

// ÇIKTI:
// Null added to list
// List: [null]
// Lower bounded wildcard'a null eklenebilir
// Unbounded ve upper bounded wildcard'a null eklenemez (type safety)


