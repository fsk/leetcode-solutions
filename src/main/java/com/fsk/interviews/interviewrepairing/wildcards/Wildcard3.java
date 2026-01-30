package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 3: Lower bounded wildcard (? super T) temel kullanımı
 * 
 * ? super Integer nedir?
 * Hangi işlemler yapılabilir?
 * Çıktı ne olur?
 */
public class Wildcard3 {
    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
        // list.add(new Object()); // HATA! Integer'dan üst tip eklenemez
    }
    
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList);
        System.out.println("Number list: " + numberList);
        
        List<Object> objectList = new ArrayList<>();
        addNumbers(objectList);
        System.out.println("Object list: " + objectList);
        
        // List<Integer> intList = new ArrayList<>();
        // addNumbers(intList); // OK, Integer super Integer
    }
}

// ÇIKTI:
// Number list: [10, 20, 30]
// Object list: [10, 20, 30]
// Lower bounded wildcard write işlemleri için uygundur
// T veya T'nin super type'larına yazılabilir




