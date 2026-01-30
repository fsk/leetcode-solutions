package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 24: Lower bounded wildcard ve inheritance chain
 * 
 * ? super T ile inheritance chain'de nasıl çalışır?
 * Çıktı ne olur?
 */
class A {
    public String toString() { return "A"; }
}

class B extends A {
    public String toString() { return "B"; }
}

class C extends B {
    public String toString() { return "C"; }
}

public class Wildcard24 {
    public static void addB(List<? super B> list) {
        list.add(new B());
        list.add(new C()); // C extends B, bu yüzden eklenebilir
        // list.add(new A()); // HATA! A super B değil
    }
    
    public static void main(String[] args) {
        List<B> listB = new ArrayList<>();
        addB(listB);
        System.out.println("List<B>: " + listB);
        
        List<A> listA = new ArrayList<>();
        addB(listA);
        System.out.println("List<A>: " + listA);
        
        // List<C> listC = new ArrayList<>();
        // addB(listC); // HATA! C super B değil
    }
}

// ÇIKTI:
// List<B>: [B, C]
// List<A>: [B, C]
// Lower bounded wildcard T veya T'nin super type'larını kabul eder
// T veya T'nin alt tipleri yazılabilir




