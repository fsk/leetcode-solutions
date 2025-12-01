package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 49: Ultimate initialization trick
 * 
 * Variable initialization + autoboxing + casting
 * Default values
 * Çıktı ne olur?
 */
public class Basic49 {
    // Instance variables - default values
    int intValue;
    Integer integerValue;
    String stringValue;
    boolean boolValue;
    Boolean boolWrapper;
    
    public static void main(String[] args) {
        Basic49 obj = new Basic49();
        System.out.println("intValue: " + obj.intValue); // 0
        System.out.println("integerValue: " + obj.integerValue); // null
        System.out.println("stringValue: " + obj.stringValue); // null
        System.out.println("boolValue: " + obj.boolValue); // false
        System.out.println("boolWrapper: " + obj.boolWrapper); // null
        
        // Local variables - must be initialized
        int localInt;
        // System.out.println(localInt); // HATA! Not initialized
        
        // Initialization with autoboxing
        Integer localInteger = 10; // Autoboxing
        System.out.println("localInteger: " + localInteger);
        
        // Initialization with casting
        int casted = (int) 10.5; // Narrowing
        System.out.println("casted: " + casted);
        
        // Initialization with ternary
        int ternary = obj.integerValue != null ? obj.integerValue : 0;
        System.out.println("ternary: " + ternary);
        
        // Initialization with method call
        int methodResult = getValue();
        System.out.println("methodResult: " + methodResult);
    }
    
    static int getValue() {
        return 100;
    }
}

// ÇIKTI:
// intValue: 0
// integerValue: null
// stringValue: null
// boolValue: false
// boolWrapper: null
// localInteger: 10
// casted: 10
// ternary: 0
// methodResult: 100
// Instance variables default değerlere sahiptir
// Local variables initialize edilmelidir




