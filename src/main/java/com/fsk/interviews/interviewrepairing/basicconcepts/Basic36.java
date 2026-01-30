package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 36: Assignment operators trick
 * 
 * +=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=, >>>=
 * Çıktı ne olur?
 */
public class Basic36 {
    public static void main(String[] args) {
        int a = 10;
        
        // +=
        a += 5; // a = a + 5
        System.out.println("a += 5: " + a); // 15
        
        // -=
        a -= 3; // a = a - 3
        System.out.println("a -= 3: " + a); // 12
        
        // *=
        a *= 2; // a = a * 2
        System.out.println("a *= 2: " + a); // 24
        
        // /=
        a /= 4; // a = a / 4
        System.out.println("a /= 4: " + a); // 6
        
        // %=
        a %= 4; // a = a % 4
        System.out.println("a %= 4: " + a); // 2
        
        // Bitwise assignment
        int b = 5; // 0101
        b &= 3; // b = b & 3 (0011) = 0001 = 1
        System.out.println("b &= 3: " + b);
        
        b |= 4; // b = b | 4 (0100) = 0101 = 5
        System.out.println("b |= 4: " + b);
        
        // Shift assignment
        int c = 8; // 1000
        c <<= 1; // c = c << 1 = 10000 = 16
        System.out.println("c <<= 1: " + c);
        
        c >>= 2; // c = c >> 2 = 100 = 4
        System.out.println("c >>= 2: " + c);
    }
}

// ÇIKTI:
// a += 5: 15
// a -= 3: 12
// a *= 2: 24
// a /= 4: 6
// a %= 4: 2
// b &= 3: 1
// b |= 4: 5
// c <<= 1: 16
// c >>= 2: 4
// Assignment operators shorthand'dır
// x op= y equivalent to x = x op y




