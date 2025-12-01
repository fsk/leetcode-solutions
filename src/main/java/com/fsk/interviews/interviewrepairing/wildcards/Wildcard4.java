package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 4: Wildcard vs type parameter farkı
 * 
 * <T> vs <?> arasındaki fark nedir?
 * Hangi durumda hangisi kullanılır?
 * Çıktı ne olur?
 */
public class Wildcard4 {
    // Type parameter - exact type bilinir
    public static <T> void method1(List<T> list) {
        T element = list.get(0);
        list.add(element); // OK, exact type bilinir
        System.out.println("Method1: " + element);
    }
    
    // Wildcard - unknown type
    public static void method2(List<?> list) {
        Object element = list.get(0);
        // list.add(element); // HATA! Unknown type
        System.out.println("Method2: " + element);
    }
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test");
        
        method1(list);
        method2(list);
    }
}

// ÇIKTI:
// Method1: test
// Method2: test
// Type parameter exact type bilir, wildcard bilmez
// Type parameter write işlemleri yapabilir, wildcard yapamaz




