package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 14: String ve number conversion tricks
 * 
 * String to number conversion
 * Number to String conversion
 * Çıktı ne olur?
 */
public class Basic14 {
    public static void main(String[] args) {
        // String to number
        String str1 = "100";
        int int1 = Integer.parseInt(str1);
        Integer int2 = Integer.valueOf(str1);
        System.out.println("int1: " + int1 + ", int2: " + int2);
        
        // Number to String
        int num = 200;
        String str2 = String.valueOf(num);
        String str3 = Integer.toString(num);
        String str4 = num + ""; // Concatenation
        System.out.println("str2: " + str2 + ", str3: " + str3 + ", str4: " + str4);
        
        // Invalid conversion
        try {
            int invalid = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }
        
        // Null conversion
        String nullStr = null;
        // int nullInt = Integer.parseInt(nullStr); // NullPointerException!
        // String nullResult = String.valueOf(null); // "null" string!
        System.out.println("String.valueOf(null): " + String.valueOf(null));
    }
}

// ÇIKTI:
// int1: 100, int2: 100
// str2: 200, str3: 200, str4: 200
// NumberFormatException: For input string: "abc"
// String.valueOf(null): null
// parseInt primitive döner, valueOf wrapper döner
// String.valueOf(null) "null" string döner




