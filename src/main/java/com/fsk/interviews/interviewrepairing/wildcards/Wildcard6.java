package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 6: Upper bounded wildcard write restriction
 * 
 * ? extends T ile neden yazma yapılamaz?
 * Çıktı ne olur?
 */
public class Wildcard6 {
    public static void addToList(List<? extends Number> list) {
        // list.add(new Integer(10)); // HATA!
        // list.add(new Double(1.5)); // HATA!
        // list.add(new Number() {}); // HATA!
        
        // Neden? Çünkü list'in exact type'ı bilinmiyor
        // ArrayList<Integer> olabilir, ArrayList<Double> olabilir
        // Integer list'e Double eklenemez!
        
        // Sadece read işlemleri
        if (!list.isEmpty()) {
            Number num = list.get(0);
            System.out.println("First number: " + num);
        }
    }
    
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        addToList(intList);
        
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        addToList(doubleList);
    }
}

// ÇIKTI:
// First number: 10
// First number: 1.5
// Upper bounded wildcard write işlemleri yapılamaz
// Çünkü exact subtype bilinmiyor, type safety korunamaz




