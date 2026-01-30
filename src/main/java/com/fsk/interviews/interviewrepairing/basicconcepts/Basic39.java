package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 39: Comparison operators trick
 * 
 * ==, !=, <, >, <=, >=
 * Primitive vs reference comparison
 * Çıktı ne olur?
 */
public class Basic39 {
    public static void main(String[] args) {
        // Primitive comparison
        int a = 10;
        int b = 10;
        int c = 20;
        System.out.println("a == b: " + (a == b)); // true (value)
        System.out.println("a != c: " + (a != c)); // true
        System.out.println("a < c: " + (a < c)); // true
        System.out.println("a > c: " + (a > c)); // false
        System.out.println("a <= b: " + (a <= b)); // true
        System.out.println("a >= c: " + (a >= c)); // false
        
        // Reference comparison
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println("s1 == s2: " + (s1 == s2)); // true (pool)
        System.out.println("s1 == s3: " + (s1 == s3)); // false (reference)
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (content)
        
        // Integer comparison
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        System.out.println("i1 == i2: " + (i1 == i2)); // true (cache)
        System.out.println("i1 < i3: " + (i1 < i3)); // true (unboxing)
        
        // Float comparison
        float f1 = 0.1f;
        float f2 = 0.1f;
        System.out.println("f1 == f2: " + (f1 == f2)); // true
        System.out.println("f1 == 0.1: " + (f1 == 0.1)); // false (float vs double)
    }
}

// ÇIKTI:
// a == b: true
// a != c: true
// a < c: true
// a > c: false
// a <= b: true
// a >= c: false
// s1 == s2: true
// s1 == s3: false
// s1.equals(s3): true
// i1 == i2: true
// i1 < i3: true
// f1 == f2: true
// f1 == 0.1: false
// == primitive'lerde value, reference'larda referans karşılaştırması
// Float ve double karşılaştırması dikkatli yapılmalı




