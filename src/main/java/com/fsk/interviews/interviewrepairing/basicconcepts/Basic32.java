package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 32: Short-circuit evaluation
 * 
 * && ve || short-circuit evaluation
 * Çıktı ne olur?
 */
public class Basic32 {
    static boolean method1() {
        System.out.println("method1() called");
        return true;
    }
    
    static boolean method2() {
        System.out.println("method2() called");
        return false;
    }
    
    public static void main(String[] args) {
        // && short-circuit
        boolean result1 = method1() && method2();
        System.out.println("result1: " + result1);
        
        // || short-circuit
        boolean result2 = method2() || method1();
        System.out.println("result2: " + result2);
        
        // No short-circuit with &
        boolean result3 = method1() & method2();
        System.out.println("result3: " + result3);
        
        // No short-circuit with |
        boolean result4 = method2() | method1();
        System.out.println("result4: " + result4);
        
        // Null check with short-circuit
        String str = null;
        if (str != null && str.length() > 0) {
            System.out.println("String not empty");
        } else {
            System.out.println("String is null or empty");
        }
    }
}

// ÇIKTI:
// method1() called
// method2() called
// result1: false
// method2() called
// method1() called
// result2: true
// method1() called
// method2() called
// result3: false
// method2() called
// method1() called
// result4: true
// String is null or empty
// && ve || short-circuit, & ve | short-circuit değil
// Short-circuit evaluation performans ve güvenlik için önemlidir


