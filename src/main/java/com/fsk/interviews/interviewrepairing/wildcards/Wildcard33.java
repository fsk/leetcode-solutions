package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * SORU 33: PECS ve Collections.addAll
 * 
 * Collections.addAll() PECS kullanır
 * Çıktı ne olur?
 */
public class Wildcard33 {
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>();
        source.add(1);
        source.add(2);
        source.add(3);
        
        // Collections.addAll signature:
        // public static <T> boolean addAll(Collection<? super T> c, T... elements)
        // c: Consumer (super)
        // elements: Producer (extends değil, varargs)
        
        List<Number> dest = new ArrayList<>();
        Collections.addAll(dest, 10, 20, 30); // Varargs
        System.out.println("Dest: " + dest);
        
        // addAll(Collection<? super T> c, Collection<? extends T> elements)
        List<Integer> source2 = new ArrayList<>();
        source2.add(100);
        source2.add(200);
        
        Collections.addAll(dest, source2.toArray(new Integer[0]));
        System.out.println("After addAll: " + dest);
    }
}

// ÇIKTI:
// Dest: [10, 20, 30]
// After addAll: [10, 20, 30, 100, 200]
// Collections.addAll() Consumer Super kullanır
// Dest: ? super T, Source: T (varargs) veya ? extends T (collection)




