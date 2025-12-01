package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 9: Wildcard ve instanceof
 * 
 * Wildcard ile instanceof kontrolü nasıl yapılır?
 * Çıktı ne olur?
 */
public class Wildcard9 {
    public static void checkType(List<?> list) {
        if (list instanceof ArrayList) {
            System.out.println("List is ArrayList");
        }
        
        if (list instanceof List) {
            System.out.println("List is List");
        }
        
        // Wildcard type erasure nedeniyle exact type kontrol edilemez
        // if (list instanceof List<String>) { } // HATA! Generic type kontrol edilemez
        
        if (!list.isEmpty()) {
            Object first = list.get(0);
            if (first instanceof String) {
                System.out.println("First element is String: " + first);
            }
            if (first instanceof Integer) {
                System.out.println("First element is Integer: " + first);
            }
        }
    }
    
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("test");
        checkType(stringList);
        
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        checkType(intList);
    }
}

// ÇIKTI:
// List is ArrayList
// List is List
// First element is String: test
// List is ArrayList
// List is List
// First element is Integer: 10
// Wildcard ile generic type kontrol edilemez (type erasure)
// Element type kontrol edilebilir




