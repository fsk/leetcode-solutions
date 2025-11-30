package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 16: Casting ve arithmetic overflow
 * 
 * Casting ile arithmetic overflow
 * Information loss
 * Çıktı ne olur?
 */
public class Basic16 {
    public static void main(String[] args) {
        // Integer overflow
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Max int: " + maxInt);
        long asLong = (long) maxInt + 1;
        System.out.println("As long: " + asLong);
        
        // Cast overflow
        long large = 300L;
        int asInt = (int) large;
        System.out.println("Large to int: " + asInt);
        
        // Byte overflow
        int value = 300;
        byte asByte = (byte) value;
        System.out.println("300 to byte: " + asByte); // 300 % 256 = 44
        System.out.println("300 % 256: " + (300 % 256));
        
        // Negative overflow
        int negative = -200;
        byte asByte2 = (byte) negative;
        System.out.println("-200 to byte: " + asByte2);
        System.out.println("-200 % 256: " + ((-200 % 256 + 256) % 256));
        
        // Float to int truncation
        float f = 10.9f;
        int truncated = (int) f;
        System.out.println("10.9f to int: " + truncated); // 10, not 11
    }
}

// ÇIKTI:
// Max int: 2147483647
// As long: 2147483648
// Large to int: 300
// 300 to byte: 44
// 300 % 256: 44
// -200 to byte: 56
// -200 % 256: 56
// 10.9f to int: 10
// Casting overflow durumunda modulo arithmetic yapılır
// Float to int truncation yapılır, rounding değil


