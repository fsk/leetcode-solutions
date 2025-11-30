package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 17: Upper bounded wildcard ve nested collections
 * 
 * List<? extends List<? extends Number>> gibi nested wildcard
 * Çıktı ne olur?
 */
public class Wildcard17 {
    public static void processNested(List<? extends List<? extends Number>> nested) {
        for (List<? extends Number> list : nested) {
            System.out.println("List size: " + list.size());
            for (Number num : list) {
                System.out.println("  Number: " + num);
            }
        }
        
        // nested.add(new ArrayList<Integer>()); // HATA!
        // nested.get(0).add(10); // HATA!
    }
    
    public static void main(String[] args) {
        List<List<Integer>> intLists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        intLists.add(list1);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        intLists.add(list2);
        
        processNested(intLists);
    }
}

// ÇIKTI:
// List size: 2
//   Number: 1
//   Number: 2
// List size: 2
//   Number: 3
//   Number: 4
// Nested wildcard kullanılabilir
// Her seviyede read-only, write yapılamaz

