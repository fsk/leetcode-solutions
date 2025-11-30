package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 45: Ultimate type conversion trick
 * 
 * Primitive + wrapper + String conversion
 * Multiple conversions
 * Çıktı ne olur?
 */
public class Basic45 {
    public static void main(String[] args) {
        // int -> Integer -> String
        int i = 100;
        Integer integer = i; // Autoboxing
        String str1 = integer.toString();
        String str2 = String.valueOf(i);
        System.out.println("str1: " + str1 + ", str2: " + str2);
        
        // String -> Integer -> int
        String str3 = "200";
        Integer integer2 = Integer.valueOf(str3);
        int i2 = integer2; // Unboxing
        int i3 = Integer.parseInt(str3);
        System.out.println("i2: " + i2 + ", i3: " + i3);
        
        // Double conversion
        double d = 10.5;
        String str4 = String.valueOf(d);
        double d2 = Double.parseDouble(str4);
        System.out.println("str4: " + str4 + ", d2: " + d2);
        
        // Char conversion
        char ch = 'A';
        String str5 = String.valueOf(ch);
        char ch2 = str5.charAt(0);
        int ascii = ch;
        System.out.println("str5: " + str5 + ", ch2: " + ch2 + ", ascii: " + ascii);
        
        // Boolean conversion
        String str6 = "true";
        boolean bool = Boolean.parseBoolean(str6);
        String str7 = String.valueOf(bool);
        System.out.println("bool: " + bool + ", str7: " + str7);
    }
}

// ÇIKTI:
// str1: 100, str2: 100
// i2: 200, i3: 200
// str4: 10.5, d2: 10.5
// str5: A, ch2: A, ascii: 65
// bool: true, str7: true
// Type conversion chain'leri dikkatli yapılmalı
// parseXXX primitive, valueOf wrapper döner


