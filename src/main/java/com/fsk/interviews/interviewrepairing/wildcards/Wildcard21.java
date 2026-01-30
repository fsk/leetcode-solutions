package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 21: Lower bounded wildcard ve write operations
 * 
 * ? super T ile hangi write işlemleri yapılabilir?
 * Çıktı ne olur?
 */
public class Wildcard21 {
    public static void addElements(List<? super Integer> list) {
        // T veya T'nin super type'larına yazılabilir
        list.add(10);
        list.add(20);
        list.add(30);
        
        // list.add(new Number() {}); // HATA! Number Integer'ın super type'ı değil
        // list.add(new Object()); // HATA! Object Integer'dan üst tip
        
        // Sadece Integer veya Integer'ın alt tipleri eklenebilir
        // Ama Integer final class, alt tip yok
    }
    
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        addElements(intList);
        System.out.println("Integer list: " + intList);
        
        List<Number> numberList = new ArrayList<>();
        addElements(numberList);
        System.out.println("Number list: " + numberList);
        
        List<Object> objectList = new ArrayList<>();
        addElements(objectList);
        System.out.println("Object list: " + objectList);
    }
}

// ÇIKTI:
// Integer list: [10, 20, 30]
// Number list: [10, 20, 30]
// Object list: [10, 20, 30]
// Lower bounded wildcard ile T veya T'nin alt tipleri yazılabilir
// T'nin super type'ları yazılamaz




