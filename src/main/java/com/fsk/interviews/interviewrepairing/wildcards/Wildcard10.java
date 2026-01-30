package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 10: Wildcard ve method return type
 * 
 * Wildcard return type kullanılabilir mi?
 * Çıktı ne olur?
 */
public class Wildcard10 {
    // Wildcard return type - genellikle kullanılmaz
    public static List<?> getList() {
        List<String> list = new ArrayList<>();
        list.add("test");
        return list; // OK, List<String> is List<?>
    }
    
    // Type parameter return type - daha iyi
    public static <T> List<T> getList2() {
        List<T> list = new ArrayList<>();
        return list;
    }
    
    public static void main(String[] args) {
        List<?> list1 = getList();
        System.out.println("List1: " + list1);
        
        // list1.add("new"); // HATA! Unknown type
        
        List<String> list2 = getList2();
        list2.add("test");
        System.out.println("List2: " + list2);
    }
}

// ÇIKTI:
// List1: [test]
// List2: [test]
// Wildcard return type kullanılabilir ama genellikle type parameter tercih edilir
// Wildcard return type ile write işlemleri yapılamaz




