package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 7: Lower bounded wildcard read restriction
 * 
 * ? super T ile okuma işlemleri nasıl yapılır?
 * Çıktı ne olur?
 */
public class Wildcard7 {
    public static void processList(List<? super Integer> list) {
        // Write işlemleri OK
        list.add(10);
        list.add(20);
        
        // Read işlemleri - sadece Object olarak
        if (!list.isEmpty()) {
            Object obj = list.get(0);
            System.out.println("First element: " + obj);
            
            // Integer num = list.get(0); // HATA! Exact type bilinmiyor
            // Number num = list.get(0); // HATA! Number olmayabilir
            
            // Sadece Object olarak okunabilir
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                System.out.println("As Integer: " + num);
            }
        }
    }
    
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        processList(numberList);
        
        List<Object> objectList = new ArrayList<>();
        processList(objectList);
    }
}

// ÇIKTI:
// First element: 10
// As Integer: 10
// First element: 10
// As Integer: 10
// Lower bounded wildcard ile write yapılabilir
// Read işlemleri sadece Object olarak yapılabilir




