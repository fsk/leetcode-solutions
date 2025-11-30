package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * SORU 23: Lower bounded wildcard ve Collections.copy
 * 
 * Collections.copy() lower bounded wildcard kullanır
 * Çıktı ne olur?
 */
public class Wildcard23 {
    public static void copyExample() {
        List<Integer> source = new ArrayList<>();
        source.add(1);
        source.add(2);
        source.add(3);
        
        // Collections.copy() signature: 
        // public static <T> void copy(List<? super T> dest, List<? extends T> src)
        List<Number> dest = new ArrayList<>();
        dest.add(0);
        dest.add(0);
        dest.add(0);
        
        Collections.copy(dest, source);
        System.out.println("Source: " + source);
        System.out.println("Dest: " + dest);
        
        // Lower bounded wildcard dest'te kullanılır
        // Upper bounded wildcard source'da kullanılır
    }
    
    public static void main(String[] args) {
        copyExample();
    }
}

// ÇIKTI:
// Source: [1, 2, 3]
// Dest: [1, 2, 3]
// Collections.copy() lower bounded wildcard kullanır
// dest: ? super T (write için)
// src: ? extends T (read için)


