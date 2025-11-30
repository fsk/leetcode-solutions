package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 44: Ultimate operator precedence trick
 * 
 * Complex expression evaluation
 * Multiple operators
 * Çıktı ne olur?
 */
public class Basic44 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 15;
        
        // Complex expression
        int result1 = a++ + ++b * c-- - --c / a;
        // a++ (5, a=6) + ++b (11, b=11) * c-- (15, c=14) - --c (13, c=13) / a (6)
        // = 5 + 11 * 15 - 13 / 6
        // = 5 + 165 - 2 (integer division)
        // = 168
        System.out.println("result1: " + result1);
        System.out.println("a: " + a + ", b: " + b + ", c: " + c);
        
        // Ternary with arithmetic
        int x = 10;
        int y = 20;
        int result2 = x > y ? x * 2 : y * 2;
        System.out.println("result2: " + result2);
        
        // Bitwise with arithmetic
        int result3 = (a & b) + (a | b) * 2;
        System.out.println("result3: " + result3);
        
        // Assignment with expression
        int d = 10;
        d += a++ * 2; // d = d + (a++ * 2)
        System.out.println("d: " + d + ", a: " + a);
    }
}

// ÇIKTI:
// result1: 168
// a: 6, b: 11, c: 13
// result2: 40
// result3: (bitwise result)
// d: (d + a*2), a: (incremented)
// Operator precedence ve evaluation order karmaşık olabilir
// Parantez kullanmak okunabilirliği artırır


