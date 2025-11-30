package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 8: Autoboxing ve array operations
 * 
 * Array'lerde autoboxing/unboxing
 * Çıktı ne olur?
 */
public class Basic8 {
    public static void main(String[] args) {
        // Primitive array
        int[] intArray = {1, 2, 3};
        
        // Wrapper array
        Integer[] integerArray = {10, 20, 30}; // Autoboxing
        
        // Array element access
        int value1 = integerArray[0]; // Unboxing
        Integer value2 = intArray[0]; // Autoboxing
        
        System.out.println("value1: " + value1);
        System.out.println("value2: " + value2);
        
        // Array iteration
        for (int num : intArray) {
            System.out.println("int: " + num);
        }
        
        for (Integer num : integerArray) {
            System.out.println("Integer: " + num);
        }
        
        // Mixed array operations
        Integer sum = 0;
        for (int num : intArray) {
            sum += num; // Unbox sum, add num, box result
        }
        System.out.println("Sum: " + sum);
    }
}

// ÇIKTI:
// value1: 10
// value2: 1
// int: 1
// int: 2
// int: 3
// Integer: 10
// Integer: 20
// Integer: 30
// Sum: 6
// Array'lerde autoboxing/unboxing element seviyesinde çalışır


