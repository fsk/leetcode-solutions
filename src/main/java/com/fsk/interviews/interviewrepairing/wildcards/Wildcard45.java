package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 45: Wildcard ve array
 * 
 * Wildcard ile array kullanımı
 * Array covariance
 * Çıktı ne olur?
 */
public class Wildcard45 {
    public static void processArray(List<? extends Number>[] arrays) {
        for (List<? extends Number> array : arrays) {
            System.out.println("Array size: " + array.size());
            for (Number num : array) {
                System.out.println("  Number: " + num);
            }
        }
        
        // arrays[0] = new ArrayList<Double>(); // HATA! Array covariance riski
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Integer>[] arrays = new List[3];
        arrays[0] = new ArrayList<>();
        arrays[0].add(10);
        
        arrays[1] = new ArrayList<>();
        arrays[1].add(20);
        
        // Array covariance
        List<? extends Number>[] numberArrays = arrays;
        processArray(numberArrays);
    }
}

// ÇIKTI:
// Array size: 1
//   Number: 10
// Array size: 1
//   Number: 20
// Array size: 0
// Wildcard ile array kullanılabilir
// Array covariance dikkatli kullanılmalı

