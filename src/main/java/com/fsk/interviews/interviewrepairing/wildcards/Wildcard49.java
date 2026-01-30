package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 49: Wildcard ve complex nested structures
 * 
 * Çok katmanlı nested wildcard
 * Map<String, List<? extends Map<? super Integer, ? extends Number>>>
 * Çıktı ne olur?
 */
import java.util.Map;
import java.util.HashMap;

public class Wildcard49 {
    public static void processComplex(
            Map<String, ? extends List<? extends Map<? super Integer, ? extends Number>>> complex) {
        for (Map.Entry<String, ? extends List<? extends Map<? super Integer, ? extends Number>>> entry : complex.entrySet()) {
            String key = entry.getKey();
            List<? extends Map<? super Integer, ? extends Number>> value = entry.getValue();
            
            System.out.println("Key: " + key);
            System.out.println("List size: " + value.size());
            
            for (Map<? super Integer, ? extends Number> map : value) {
                System.out.println("  Map size: " + map.size());
                for (Map.Entry<? super Integer, ? extends Number> mapEntry : map.entrySet()) {
                    System.out.println("    " + mapEntry.getKey() + " -> " + mapEntry.getValue());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Map<Integer, Number> map1 = new HashMap<>();
        map1.put(1, 10);
        map1.put(2, 20.5);
        
        Map<Integer, Number> map2 = new HashMap<>();
        map2.put(3, 30);
        
        List<Map<Integer, Number>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        
        Map<String, List<Map<Integer, Number>>> complex = new HashMap<>();
        complex.put("data", list);
        
        processComplex(complex);
    }
}

// ÇIKTI:
// Key: data
// List size: 2
//   Map size: 2
//     1 -> 10
//     2 -> 20.5
//   Map size: 1
//     3 -> 30
// Çok katmanlı nested wildcard kullanılabilir
// Her seviyede PECS pattern uygulanır




