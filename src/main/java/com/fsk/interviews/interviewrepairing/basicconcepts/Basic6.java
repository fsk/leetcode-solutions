package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 6: Autoboxing ve ternary operator
 * 
 * Ternary operator'da autoboxing nasıl çalışır?
 * Type inference
 * Çıktı ne olur?
 */
public class Basic6 {
    public static void main(String[] args) {
        boolean condition = true;
        
        // Ternary with primitives
        int result1 = condition ? 10 : 20;
        System.out.println("result1: " + result1 + ", type: " + 
            ((Object) result1).getClass().getSimpleName());
        
        // Ternary with mixed types
        Number result2 = condition ? 10 : 20.5; // int ve double
        System.out.println("result2: " + result2 + ", type: " + 
            result2.getClass().getSimpleName());
        
        // Ternary with null
        Integer result3 = condition ? null : 10;
        System.out.println("result3: " + result3);
        
        // Ternary with autoboxing
        Integer result4 = condition ? 10 : 20; // Autoboxing
        System.out.println("result4: " + result4 + ", type: " + 
            result4.getClass().getSimpleName());
        
        // Ternary type inference trick
        Object result5 = condition ? new Integer(10) : new Double(20.5);
        System.out.println("result5: " + result5 + ", type: " + 
            result5.getClass().getSimpleName());
    }
}

// ÇIKTI:
// result1: 10, type: Integer (boxed for getClass())
// result2: 10.0, type: Double (int -> double promotion)
// result3: null
// result4: 10, type: Integer
// result5: 10, type: Integer (common supertype)
// Ternary operator type inference karmaşık kurallara sahiptir


