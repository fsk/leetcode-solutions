package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 2: Autoboxing ve arithmetic operations
 * 
 * Autoboxing/unboxing arithmetic işlemlerde nasıl çalışır?
 * Çıktı ne olur?
 */
public class Basic2 {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        
        // Autoboxing/unboxing
        Integer sum = a + b; // a.intValue() + b.intValue(), sonra box
        System.out.println("sum: " + sum);
        System.out.println("sum type: " + sum.getClass().getSimpleName());
        
        // Arithmetic operations
        Integer result1 = a + b * 2; // Unbox, calculate, box
        Integer result2 = (a + b) * 2;
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        
        // Null unboxing
        Integer nullInt = null;
        // int value = nullInt; // NullPointerException!
        // int result = nullInt + 10; // NullPointerException!
    }
}

// ÇIKTI:
// sum: 30
// sum type: Integer
// result1: 50
// result2: 60
// Autoboxing/unboxing arithmetic işlemlerde otomatik yapılır
// Null unboxing NullPointerException fırlatır


