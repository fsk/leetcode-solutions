package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 25: Lower bounded wildcard ve remove operations
 * 
 * ? super T ile remove işlemleri yapılabilir mi?
 * Çıktı ne olur?
 */
public class Wildcard25 {
    public static void removeOperations(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Before remove: " + list);
        
        // remove(Object) - OK
        list.remove(Integer.valueOf(20));
        System.out.println("After remove 20: " + list);
        
        // remove(int index) - OK
        list.remove(0);
        System.out.println("After remove index 0: " + list);
        
        // removeAll, retainAll - OK (Collection<?> parametresi)
        List<Integer> toRemove = new ArrayList<>();
        toRemove.add(30);
        list.removeAll(toRemove);
        System.out.println("After removeAll: " + list);
    }
    
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        removeOperations(list);
    }
}

// ÇIKTI:
// Before remove: [10, 20, 30]
// After remove 20: [10, 30]
// After remove index 0: [30]
// After removeAll: []
// Lower bounded wildcard ile remove işlemleri yapılabilir
// remove(Object) ve remove(int) kullanılabilir




