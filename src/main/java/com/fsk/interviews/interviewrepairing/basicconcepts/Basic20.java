package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 20: Casting ve method return type
 * 
 * Method return type casting
 * Covariant return types
 * Çıktı ne olur?
 */
class Basic20A {
    Object getValue() {
        return "A";
    }
}

class Basic20B extends Basic20A {
    @Override
    String getValue() { // Covariant return type
        return "B";
    }
}

public class Basic20 {
    static Object getObject() {
        return "test";
    }
    
    static String getString() {
        return "test";
    }
    
    public static void main(String[] args) {
        // Return type casting
        Object obj = getString();
        String str = (String) getObject();
        System.out.println("obj: " + obj);
        System.out.println("str: " + str);
        
        // Covariant return type
        Basic20A objA = new Basic20B();
        Object value = objA.getValue();
        System.out.println("value: " + value + ", type: " + value.getClass().getSimpleName());
        
        // Cast return value
        String casted = (String) objA.getValue();
        System.out.println("casted: " + casted);
        
        // Method chaining with cast
        String result = (String) getObject();
        System.out.println("result length: " + result.length());
    }
}

// ÇIKTI:
// obj: test
// str: test
// value: B, type: String
// casted: B
// result length: 4
// Method return type casting yapılabilir
// Covariant return type runtime'da doğru tip döner


