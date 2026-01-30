package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * SORU 20: Upper bounded wildcard ve utility methods
 * 
 * Collections utility metodları ile upper bounded wildcard
 * Çıktı ne olur?
 */
public class Wildcard20 {
    public static void utilities(List<? extends Number> list) {
        // Collections.max() - Comparable gerekli
        // Number Comparable değil, bu yüzden kullanılamaz
        // Number max = Collections.max(list); // HATA!
        
        // Collections.frequency()
        System.out.println("Frequency of 10: " + Collections.frequency(list, 10));
        
        // Collections.disjoint()
        List<Integer> other = new ArrayList<>();
        other.add(100);
        System.out.println("Disjoint: " + Collections.disjoint(list, other));
        
        // Collections.copy() - target wildcard olamaz
        // List<? extends Number> copy = new ArrayList<>();
        // Collections.copy(copy, list); // HATA!
        
        List<Number> copy = new ArrayList<>();
        Collections.copy(copy, list); // OK, exact type
        System.out.println("Copy: " + copy);
    }
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(10);
        utilities(list);
    }
}

// ÇIKTI:
// Frequency of 10: 2
// Disjoint: true
// Copy: [10, 20, 10]
// Bazı Collections utility metodları wildcard ile kullanılabilir
// Bazıları exact type gerektirir




