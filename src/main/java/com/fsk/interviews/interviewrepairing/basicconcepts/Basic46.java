package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 46: Ultimate null handling trick
 * 
 * Null + autoboxing + casting + String
 * NullPointerException scenarios
 * Çıktı ne olur?
 */
public class Basic46 {
    public static void main(String[] args) {
        // Null Integer
        Integer nullInt = null;
        // int value = nullInt; // NullPointerException!
        System.out.println("nullInt == null: " + (nullInt == null));
        
        // Null String
        String nullStr = null;
        String result = nullStr + "test"; // "nulltest"
        System.out.println("result: " + result);
        // int len = nullStr.length(); // NullPointerException!
        
        // Null in ternary
        String ternary = nullStr != null ? nullStr : "default";
        System.out.println("ternary: " + ternary);
        
        // Null with instanceof
        Object nullObj = null;
        System.out.println("nullObj instanceof String: " + (nullObj instanceof String));
        
        // Null safe equals
        String str1 = "test";
        String str2 = null;
        System.out.println("Objects.equals(str1, str2): " + java.util.Objects.equals(str1, str2));
        System.out.println("Objects.equals(str2, str2): " + java.util.Objects.equals(str2, str2));
        
        // Null casting
        String str3 = (String) nullObj; // OK, null cast edilebilir
        System.out.println("str3: " + str3);
    }
}

// ÇIKTI:
// nullInt == null: true
// result: nulltest
// ternary: default
// nullObj instanceof String: false
// Objects.equals(str1, str2): false
// Objects.equals(str2, str2): true
// str3: null
// Null unboxing NullPointerException fırlatır
// Null String concatenation "null" string oluşturur
// Null casting mümkündür


