package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 2: Upper bounded wildcard (? extends T) temel kullanımı
 * 
 * ? extends Number nedir?
 * Hangi işlemler yapılabilir?
 * Çıktı ne olur?
 */
public class Wildcard2 {
    public static double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        doubleList.add(2.5);
        
        System.out.println("Sum of integers: " + sum(intList));
        System.out.println("Sum of doubles: " + sum(doubleList));
        
        // List<? extends Number> list = new ArrayList<Integer>();
        // list.add(new Integer(10)); // HATA! Unknown subtype
    }
}

// ÇIKTI:
// Sum of integers: 30.0
// Sum of doubles: 4.0
// Upper bounded wildcard read-only işlemler için uygundur
// Write işlemleri yapılamaz çünkü exact subtype bilinmiyor




