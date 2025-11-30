package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 31: Operator precedence trick
 * 
 * Operator precedence nasıl çalışır?
 * Çıktı ne olur?
 */
public class Basic31 {
    public static void main(String[] args) {
        // Precedence: * > +
        int result1 = 2 + 3 * 4;
        System.out.println("2 + 3 * 4 = " + result1); // 14, not 20
        
        // Precedence: () > *
        int result2 = (2 + 3) * 4;
        System.out.println("(2 + 3) * 4 = " + result2); // 20
        
        // Precedence: && > ||
        boolean result3 = true || false && false;
        System.out.println("true || false && false = " + result3); // true
        
        // Precedence: == > =
        int a = 10;
        boolean result4 = a == 20;
        System.out.println("a == 20: " + result4); // false
        
        // Precedence: ++ > *
        int b = 2;
        int result5 = ++b * 3;
        System.out.println("++b * 3 = " + result5 + ", b = " + b); // 9, b = 3
        
        // Precedence: * > %
        int result6 = 10 % 3 * 2;
        System.out.println("10 % 3 * 2 = " + result6); // 2, not 4
    }
}

// ÇIKTI:
// 2 + 3 * 4 = 14
// (2 + 3) * 4 = 20
// true || false && false = true
// a == 20: false
// ++b * 3 = 9, b = 3
// 10 % 3 * 2 = 2
// Operator precedence matematiksel kurallara benzer
// Parantez en yüksek önceliğe sahiptir


