package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 30: Lower bounded wildcard ve iterator
 * 
 * ? super T ile iterator kullanımı
 * Çıktı ne olur?
 */
import java.util.Iterator;

public class Wildcard30 {
    public static void iterate(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
        
        // Iterator - Object olarak döner
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("Element: " + obj);
            
            // Remove via iterator - OK
            if (obj instanceof Integer && (Integer) obj == 20) {
                iterator.remove();
            }
        }
        
        System.out.println("After iteration: " + list);
    }
    
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        iterate(list);
    }
}

// ÇIKTI:
// Element: 10
// Element: 20
// Element: 30
// After iteration: [10, 30]
// Lower bounded wildcard ile iterator kullanılabilir
// Iterator Object döner, remove() yapılabilir


