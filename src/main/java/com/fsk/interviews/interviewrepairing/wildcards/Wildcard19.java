package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 19: Upper bounded wildcard ve equals/hashCode
 * 
 * ? extends T ile equals ve hashCode kullanımı
 * Çıktı ne olur?
 */
public class Wildcard19 {
    public static void compare(List<? extends Number> list1, List<? extends Number> list2) {
        // equals() kullanılabilir
        System.out.println("Lists equal: " + list1.equals(list2));
        
        // hashCode() kullanılabilir
        System.out.println("List1 hashCode: " + list1.hashCode());
        System.out.println("List2 hashCode: " + list2.hashCode());
        
        // contains() kullanılabilir
        if (!list1.isEmpty()) {
            Number first = list1.get(0);
            System.out.println("List2 contains first: " + list2.contains(first));
        }
    }
    
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        
        List<Double> list3 = new ArrayList<>();
        list3.add(10.0);
        list3.add(20.0);
        
        compare(list1, list2);
        compare(list1, list3);
    }
}

// ÇIKTI:
// Lists equal: true
// List1 hashCode: (hash code)
// List2 hashCode: (hash code)
// List2 contains first: true
// Lists equal: false
// List1 hashCode: (hash code)
// List3 hashCode: (hash code)
// List3 contains first: false
// Upper bounded wildcard ile equals, hashCode, contains kullanılabilir




