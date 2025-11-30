package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 7: Autoboxing ve method return type
 * 
 * Method return type'da autoboxing
 * Primitive return vs wrapper return
 * Çıktı ne olur?
 */
public class Basic7 {
    static int getInt() {
        return 10;
    }
    
    static Integer getInteger() {
        return 20; // Autoboxing
    }
    
    static Integer getInteger2() {
        int value = 30;
        return value; // Autoboxing
    }
    
    public static void main(String[] args) {
        int a = getInt(); // No boxing
        Integer b = getInt(); // Autoboxing
        int c = getInteger(); // Unboxing
        Integer d = getInteger(); // No unboxing
        
        System.out.println("a: " + a + ", type: " + ((Object) a).getClass().getSimpleName());
        System.out.println("b: " + b + ", type: " + b.getClass().getSimpleName());
        System.out.println("c: " + c + ", type: " + ((Object) c).getClass().getSimpleName());
        System.out.println("d: " + d + ", type: " + d.getClass().getSimpleName());
        
        System.out.println("getInteger2(): " + getInteger2());
    }
}

// ÇIKTI:
// a: 10, type: Integer (boxed for getClass())
// b: 10, type: Integer
// c: 20, type: Integer (boxed for getClass())
// d: 20, type: Integer
// getInteger2(): 30
// Method return type'da autoboxing/unboxing otomatik yapılır


