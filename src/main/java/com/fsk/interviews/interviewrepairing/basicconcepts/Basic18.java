package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 18: Casting ve array covariance
 * 
 * Array casting ve covariance
 * ArrayStoreException riski
 * Çıktı ne olur?
 */
public class Basic18 {
    public static void main(String[] args) {
        // Array covariance
        String[] stringArray = {"a", "b", "c"};
        Object[] objectArray = stringArray; // Covariance
        
        System.out.println("objectArray[0]: " + objectArray[0]);
        
        // ArrayStoreException riski
        try {
            objectArray[0] = new Integer(10); // Runtime error!
        } catch (ArrayStoreException e) {
            System.out.println("ArrayStoreException: " + e.getMessage());
        }
        
        // Primitive array casting
        int[] intArray = {1, 2, 3};
        // Object[] objArray2 = intArray; // HATA! Primitive array Object[] değil
        
        // Array type casting
        Object[] objArray = new String[5];
        objArray[0] = "test";
        String[] strArray = (String[]) objArray; // OK
        System.out.println("strArray[0]: " + strArray[0]);
        
        // Invalid cast
        Object[] objArray2 = new Integer[5];
        try {
            String[] strArray2 = (String[]) objArray2; // ClassCastException!
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
    }
}

// ÇIKTI:
// objectArray[0]: a
// ArrayStoreException: ...
// strArray[0]: test
// ClassCastException: ...
// Array covariance tehlikeli, ArrayStoreException riski var
// Primitive array Object[] değildir




