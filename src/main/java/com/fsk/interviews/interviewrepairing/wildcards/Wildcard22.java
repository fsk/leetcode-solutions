package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 22: Lower bounded wildcard ve read operations
 * 
 * ? super T ile read işlemleri nasıl yapılır?
 * Çıktı ne olur?
 */
public class Wildcard22 {
    public static void readOperations(List<? super Integer> list) {
        // Read işlemleri - sadece Object olarak
        System.out.println("Size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
        
        if (!list.isEmpty()) {
            Object first = list.get(0);
            System.out.println("First element: " + first);
            System.out.println("First type: " + first.getClass().getSimpleName());
            
            // Integer num = list.get(0); // HATA! Exact type bilinmiyor
            // Number num = list.get(0); // HATA! Number olmayabilir
            
            // Safe casting
            if (first instanceof Integer) {
                Integer num = (Integer) first;
                System.out.println("As Integer: " + num);
            }
        }
        
        // contains() - Object parametresi
        System.out.println("Contains 10: " + list.contains(10));
        System.out.println("Contains 'test': " + list.contains("test"));
    }
    
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20.5);
        readOperations(numberList);
    }
}

// ÇIKTI:
// Size: 2
// Is empty: false
// First element: 10
// First type: Integer
// As Integer: 10
// Contains 10: true
// Contains 'test': false
// Lower bounded wildcard ile read işlemleri sadece Object olarak yapılabilir


