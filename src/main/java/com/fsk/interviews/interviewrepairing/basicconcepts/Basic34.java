package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 34: Ternary operator trick
 * 
 * Ternary operator type inference
 * Nested ternary
 * Çıktı ne olur?
 */
public class Basic34 {
    public static void main(String[] args) {
        // Basic ternary
        int a = 10;
        int b = 20;
        int max = a > b ? a : b;
        System.out.println("max: " + max);
        
        // Type inference
        Object obj = true ? 10 : 20.5; // Common type: Number -> Double
        System.out.println("obj: " + obj + ", type: " + obj.getClass().getSimpleName());
        
        // Null in ternary
        String str = true ? null : "test";
        System.out.println("str: " + str);
        
        // Nested ternary
        int x = 10;
        int y = 20;
        int z = 30;
        int result = x > y ? (x > z ? x : z) : (y > z ? y : z);
        System.out.println("result: " + result);
        
        // Ternary with method call
        String result2 = a > b ? "a is greater" : "b is greater";
        System.out.println("result2: " + result2);
        
        // Ternary assignment
        int value = a > 5 ? (b > 15 ? 100 : 200) : 300;
        System.out.println("value: " + value);
    }
}

// ÇIKTI:
// max: 20
// obj: 10.0, type: Double
// str: null
// result: 30
// result2: b is greater
// value: 200
// Ternary operator type inference karmaşık kurallara sahiptir
// Nested ternary okunabilirliği azaltır




