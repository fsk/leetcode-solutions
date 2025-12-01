package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 1: Unbounded wildcard (?) temel kullanımı
 * 
 * List<?> nedir?
 * Hangi durumlarda kullanılır?
 * Çıktı ne olur?
 */
public class Wildcard1 {
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
    
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        
        printList(stringList);
        printList(intList);
        
        // List<?> list = new ArrayList<String>(); // OK
        // list.add("test"); // HATA! Unknown type
    }
}

// ÇIKTI:
// Hello
// World
// 1
// 2
// Unbounded wildcard (?) herhangi bir tip için kullanılır
// Read-only işlemler için uygundur, write işlemleri yapılamaz




