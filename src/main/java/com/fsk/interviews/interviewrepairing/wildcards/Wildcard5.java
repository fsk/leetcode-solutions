package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 5: Wildcard read işlemleri
 * 
 * Wildcard ile hangi read işlemleri yapılabilir?
 * Çıktı ne olur?
 */
public class Wildcard5 {
    public static void processList(List<?> list) {
        // Read işlemleri
        System.out.println("Size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());
        
        if (!list.isEmpty()) {
            Object first = list.get(0);
            System.out.println("First element: " + first);
        }
        
        // Iteration
        for (Object obj : list) {
            System.out.println("Element: " + obj);
        }
        
        // Contains, indexOf gibi metodlar
        System.out.println("Contains 'test': " + list.contains("test"));
        
        // list.add("test"); // HATA! Write işlemi yapılamaz
        // list.remove(0); // HATA! Write işlemi yapılamaz
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        
        processList(list);
    }
}

// ÇIKTI:
// Size: 2
// Is empty: false
// First element: Hello
// Element: Hello
// Element: World
// Contains 'test': false
// Wildcard ile read işlemleri yapılabilir, write işlemleri yapılamaz


