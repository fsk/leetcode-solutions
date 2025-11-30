package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 33: Increment/decrement operator trick
 * 
 * Pre-increment vs post-increment
 * Çıktı ne olur?
 */
public class Basic33 {
    public static void main(String[] args) {
        int a = 10;
        int b = ++a; // Pre-increment: a önce artırılır, sonra b'ye atanır
        System.out.println("a = " + a + ", b = " + b); // a = 11, b = 11
        
        int c = 10;
        int d = c++; // Post-increment: c önce d'ye atanır, sonra artırılır
        System.out.println("c = " + c + ", d = " + d); // c = 11, d = 10
        
        // Complex expression
        int e = 10;
        int f = e++ + ++e; // e++ (10, e=11) + ++e (e=12, 12) = 22
        System.out.println("e = " + e + ", f = " + f); // e = 12, f = 22
        
        // In loop
        int sum = 0;
        for (int i = 0; i < 5; i++) { // i++ post-increment
            sum += i;
        }
        System.out.println("sum = " + sum); // 0+1+2+3+4 = 10
        
        // Multiple increments
        int g = 5;
        int h = ++g + g++ + ++g; // ++g (6, g=6) + g++ (6, g=7) + ++g (8, g=8) = 20
        System.out.println("g = " + g + ", h = " + h); // g = 8, h = 20
    }
}

// ÇIKTI:
// a = 11, b = 11
// c = 11, d = 10
// e = 12, f = 22
// sum = 10
// g = 8, h = 20
// Pre-increment: önce artır, sonra kullan
// Post-increment: önce kullan, sonra artır


