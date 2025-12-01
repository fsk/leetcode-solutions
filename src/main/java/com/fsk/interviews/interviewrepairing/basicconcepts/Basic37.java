package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 37: String concatenation operator
 * 
 * + operator String concatenation
 * Type conversion in concatenation
 * Çıktı ne olur?
 */
public class Basic37 {
    public static void main(String[] args) {
        // String concatenation
        String s1 = "Hello" + " " + "World";
        System.out.println("s1: " + s1);
        
        // Number to String conversion
        int num = 10;
        String s2 = "Number: " + num; // num converted to String
        System.out.println("s2: " + s2);
        
        // Mixed types
        String s3 = "Value: " + 10 + 20; // "Value: 10" + "20" = "Value: 1020"
        System.out.println("s3: " + s3);
        
        String s4 = "Value: " + (10 + 20); // "Value: " + 30 = "Value: 30"
        System.out.println("s4: " + s4);
        
        // Null concatenation
        String nullStr = null;
        String s5 = "Test: " + nullStr; // "Test: null"
        System.out.println("s5: " + s5);
        
        // Boolean concatenation
        boolean bool = true;
        String s6 = "Boolean: " + bool; // "Boolean: true"
        System.out.println("s6: " + s6);
        
        // Char concatenation
        char ch = 'A';
        String s7 = "Char: " + ch; // "Char: A"
        System.out.println("s7: " + s7);
    }
}

// ÇIKTI:
// s1: Hello World
// s2: Number: 10
// s3: Value: 1020
// s4: Value: 30
// s5: Test: null
// s6: Boolean: true
// s7: Char: A
// + operator String ile concatenation yapar
// Primitive types String'e otomatik convert edilir
// Precedence önemlidir: () > + (concatenation)




