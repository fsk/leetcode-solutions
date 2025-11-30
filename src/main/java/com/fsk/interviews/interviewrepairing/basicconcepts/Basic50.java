package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 50: Ultimate Java basics challenge
 * 
 * TÜM KONSEPTLERİ BİRLEŞTİREN ULTIMATE CHALLENGE
 * Boxing/Unboxing + Casting + String + Operators + Null + Arrays
 * Çıktı ne olur?
 */
public class Basic50 {
    static String process(Integer value, String prefix, int multiplier) {
        if (value == null) {
            return prefix + "null";
        }
        int result = value * multiplier; // Unboxing, arithmetic, result is int
        return prefix + result; // int to String conversion
    }
    
    static Integer calculate(int[] array, Integer defaultValue) {
        if (array == null || array.length == 0) {
            return defaultValue; // Autoboxing if needed
        }
        int sum = 0;
        for (int num : array) {
            sum += num; // Primitive arithmetic
        }
        return sum; // Autoboxing
    }
    
    public static void main(String[] args) {
        // Complex scenario 1: Null handling + autoboxing + String
        Integer nullInt = null;
        String result1 = process(nullInt, "Value: ", 2);
        System.out.println("result1: " + result1);
        
        // Complex scenario 2: Array + autoboxing + calculation
        int[] numbers = {10, 20, 30};
        Integer sum = calculate(numbers, 0);
        System.out.println("sum: " + sum);
        
        // Complex scenario 3: String + == + equals
        String s1 = "test";
        String s2 = new String("test");
        String s3 = s1 + ""; // Runtime concatenation
        System.out.println("s1 == s2: " + (s1 == s2)); // false
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
        System.out.println("s1 == s3: " + (s1 == s3)); // false
        
        // Complex scenario 4: Casting + autoboxing + arithmetic
        Integer intObj = 100;
        long longVal = intObj; // Unboxing + widening
        double doubleVal = longVal; // Widening
        int backToInt = (int) doubleVal; // Narrowing
        System.out.println("backToInt: " + backToInt);
        
        // Complex scenario 5: Operator precedence + autoboxing
        Integer a = 10;
        Integer b = 20;
        Integer result2 = a + b * 2; // Unbox, calculate, box
        System.out.println("result2: " + result2);
        
        // Complex scenario 6: Ternary + null + autoboxing
        Integer value = true ? null : 10;
        int safeValue = value != null ? value : 0; // Null check + unboxing
        System.out.println("safeValue: " + safeValue);
    }
}

// ÇIKTI:
// result1: Valuenull
// sum: 60
// s1 == s2: false
// s1.equals(s2): true
// s1 == s3: false
// backToInt: 100
// result2: 50
// safeValue: 0
// ULTIMATE CHALLENGE: Tüm Java basics konseptleri bir arada!
// Boxing/Unboxing + Casting + String + Operators + Null + Arrays
// Bu sorular en iyi Java geliştiricileri bile zorlar!

