package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 40: Wildcard ve nested generics
 * 
 * Map<? extends List<? extends Number>> gibi nested wildcard
 * Çıktı ne olur?
 */
import java.util.Map;
import java.util.HashMap;

public class Wildcard40 {
    public static void processNested(Map<String, ? extends List<? extends Number>> map) {
        for (Map.Entry<String, ? extends List<? extends Number>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<? extends Number> value = entry.getValue();
            
            System.out.println("Key: " + key);
            System.out.println("Value size: " + value.size());
            
            for (Number num : value) {
                System.out.println("  Number: " + num);
            }
        }
        
        // map.put("new", new ArrayList<Integer>()); // HATA!
        // map.get("key").add(10); // HATA!
    }
    
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        map.put("ints", list1);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(30);
        map.put("more", list2);
        
        processNested(map);
    }
}

// ÇIKTI:
// Key: ints
// Value size: 2
//   Number: 10
//   Number: 20
// Key: more
// Value size: 1
//   Number: 30
// Nested wildcard kullanılabilir
// Her seviyede read-only, write yapılamaz


