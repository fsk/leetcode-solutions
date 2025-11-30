package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 35: Wildcard capture
 * 
 * Wildcard capture nedir?
 * Helper method pattern
 * Çıktı ne olur?
 */
public class Wildcard35 {
    // Wildcard parameter - swap yapılamaz
    // public static void swap(List<?> list, int i, int j) {
    //     Object temp = list.get(i);
    //     list.set(i, list.get(j)); // HATA!
    //     list.set(j, temp); // HATA!
    // }
    
    // Helper method ile wildcard capture
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }
    
    // Helper method - type parameter kullan
    private static <T> void swapHelper(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        
        System.out.println("Before swap: " + list);
        swap(list, 0, 2);
        System.out.println("After swap: " + list);
    }
}

// ÇIKTI:
// Before swap: [A, B, C]
// After swap: [C, B, A]
// Wildcard capture: Helper method ile wildcard'ı type parameter'a capture et
// Bu sayede write işlemleri yapılabilir


