package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 29: Lower bounded wildcard ve clear operations
 * 
 * ? super T ile clear işlemleri yapılabilir mi?
 * Çıktı ne olur?
 */
public class Wildcard29 {
    public static void clearOperations(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Before clear: " + list);
        
        // clear() - OK
        list.clear();
        System.out.println("After clear: " + list);
        System.out.println("Is empty: " + list.isEmpty());
        
        // removeAll(Collection<?> c) - OK
        list.add(10);
        list.add(20);
        List<Integer> toRemove = new ArrayList<>();
        toRemove.add(10);
        list.removeAll(toRemove);
        System.out.println("After removeAll: " + list);
        
        // retainAll(Collection<?> c) - OK
        list.add(30);
        List<Integer> toRetain = new ArrayList<>();
        toRetain.add(20);
        list.retainAll(toRetain);
        System.out.println("After retainAll: " + list);
    }
    
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        clearOperations(list);
    }
}

// ÇIKTI:
// Before clear: [10, 20, 30]
// After clear: []
// Is empty: true
// After removeAll: [20]
// After retainAll: [20]
// Lower bounded wildcard ile clear, removeAll, retainAll yapılabilir
// Collection<?> parametreli metodlar kullanılabilir


