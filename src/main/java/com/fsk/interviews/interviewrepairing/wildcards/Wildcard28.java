package com.fsk.interviews.interviewrepairing.wildcards;

import java.util.List;
import java.util.ArrayList;

/**
 * SORU 28: Lower bounded wildcard ve method parameter
 * 
 * Method parameter'da lower bounded wildcard kullanımı
 * Çıktı ne olur?
 */
public class Wildcard28 {
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
    
    @SafeVarargs
    public static void addToMultiple(List<? super Integer>... lists) {
        for (List<? super Integer> list : lists) {
            addNumbers(list);
        }
    }
    
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        
        addNumbers(intList);
        addNumbers(numberList);
        addNumbers(objectList);
        
        System.out.println("Integer list: " + intList);
        System.out.println("Number list: " + numberList);
        System.out.println("Object list: " + objectList);
        
        // Varargs ile
        addToMultiple(intList, numberList, objectList);
        System.out.println("After varargs: " + intList);
    }
}

// ÇIKTI:
// Integer list: [1, 2, 3]
// Number list: [1, 2, 3]
// Object list: [1, 2, 3]
// After varargs: [1, 2, 3, 1, 2, 3]
// Lower bounded wildcard method parameter'da kullanılabilir
// Varargs ile de kullanılabilir

