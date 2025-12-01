package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 35: Bitwise operators trick
 * 
 * &, |, ^, ~, <<, >>, >>>
 * Çıktı ne olur?
 */
public class Basic35 {
    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011
        
        // AND
        int and = a & b; // 0001 = 1
        System.out.println("a & b = " + and);
        
        // OR
        int or = a | b; // 0111 = 7
        System.out.println("a | b = " + or);
        
        // XOR
        int xor = a ^ b; // 0110 = 6
        System.out.println("a ^ b = " + xor);
        
        // NOT
        int not = ~a; // 1111...1010 (two's complement)
        System.out.println("~a = " + not);
        
        // Left shift
        int left = a << 2; // 0101 -> 10100 = 20
        System.out.println("a << 2 = " + left);
        
        // Right shift (signed)
        int right = a >> 1; // 0101 -> 0010 = 2
        System.out.println("a >> 1 = " + right);
        
        // Unsigned right shift
        int unsigned = -1 >>> 1; // Fill with 0
        System.out.println("-1 >>> 1 = " + unsigned);
        
        // Practical: Check if even/odd
        boolean isEven = (a & 1) == 0;
        System.out.println("a is even: " + isEven);
    }
}

// ÇIKTI:
// a & b = 1
// a | b = 7
// a ^ b = 6
// ~a = -6
// a << 2 = 20
// a >> 1 = 2
// -1 >>> 1 = 2147483647
// a is even: false
// Bitwise operators bit seviyesinde işlem yapar
// >> signed, >>> unsigned right shift




