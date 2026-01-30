package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 26: Lower bounded wildcard ve set operations
 * 
 * ? super T ile set işlemleri yapılabilir mi?
 * Çıktı ne olur?
 */
public class Wildcard26 {
    public static void setOperations(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        System.out.println("Before set: " + list);
        
        // set(int index, E element) - OK
        list.set(0, 100);
        System.out.println("After set(0, 100): " + list);
        
        // add(int index, E element) - OK
        list.add(1, 200);
        System.out.println("After add(1, 200): " + list);
        
        // addAll(int index, Collection<? extends E> c) - OK
        List<Integer> toAdd = new ArrayList<>();
        toAdd.add(300);
        toAdd.add(400);
        list.addAll(toAdd);
        System.out.println("After addAll: " + list);
    }
    
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        setOperations(list);
    }
}

// ÇIKTI:
// Before set: [10, 20]
// After set(0, 100): [100, 20]
// After set(1, 200): [100, 200, 20]
// After addAll: [100, 200, 20, 300, 400]
// Lower bounded wildcard ile set işlemleri yapılabilir
// T veya T'nin alt tipleri set edilebilir




