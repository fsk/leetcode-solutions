package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 48: Ultimate array trick
 * 
 * Array + casting + covariance + autoboxing
 * ArrayStoreException riski
 * Çıktı ne olur?
 */
public class Basic48 {
    public static void main(String[] args) {
        // Primitive array
        int[] intArray = {1, 2, 3};
        // Object[] objArray = intArray; // HATA! Primitive array Object[] değil
        
        // Reference array covariance
        String[] strArray = {"a", "b", "c"};
        Object[] objArray = strArray; // Covariance
        
        // ArrayStoreException
        try {
            objArray[0] = new Integer(10); // Runtime error!
        } catch (ArrayStoreException e) {
            System.out.println("ArrayStoreException: " + e.getMessage());
        }
        
        // Wrapper array
        Integer[] integerArray = {10, 20, 30}; // Autoboxing
        Number[] numberArray = integerArray; // Covariance
        
        // Autoboxing in array
        int value = integerArray[0]; // Unboxing
        integerArray[1] = 40; // Autoboxing
        System.out.println("value: " + value);
        System.out.println("integerArray[1]: " + integerArray[1]);
        
        // Array casting
        Object[] objArray2 = new String[5];
        String[] strArray2 = (String[]) objArray2; // OK
        System.out.println("Cast successful");
    }
}

// ÇIKTI:
// ArrayStoreException: ...
// value: 10
// integerArray[1]: 40
// Cast successful
// Array covariance tehlikeli, ArrayStoreException riski var
// Primitive array Object[] değildir
// Wrapper array'lerde autoboxing/unboxing çalışır


