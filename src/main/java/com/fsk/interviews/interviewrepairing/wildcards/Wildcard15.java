package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 15: Upper bounded wildcard ve casting
 * 
 * ? extends T ile casting nasıl yapılır?
 * Çıktı ne olur?
 */
public class Wildcard15 {
    public static void process(List<? extends Number> list) {
        if (!list.isEmpty()) {
            Number num = list.get(0);
            
            // Safe casting
            if (num instanceof Integer) {
                Integer i = (Integer) num;
                System.out.println("As Integer: " + i);
            }
            
            if (num instanceof Double) {
                Double d = (Double) num;
                System.out.println("As Double: " + d);
            }
            
            // Unsafe casting - ClassCastException riski
            // Integer i = (Integer) list.get(0); // Risk!
        }
    }
    
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        process(intList);
        
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        process(doubleList);
    }
}

// ÇIKTI:
// As Integer: 10
// As Double: 1.5
// Upper bounded wildcard ile casting yapılabilir
// instanceof kontrolü ile safe casting yapılmalı


