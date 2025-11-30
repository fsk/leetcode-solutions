package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 29: String ve switch statement
 * 
 * Switch statement String ile nasıl çalışır?
 * == vs equals() in switch
 * Çıktı ne olur?
 */
public class Basic29 {
    static void switchString(String str) {
        switch (str) {
            case "hello":
                System.out.println("Case hello");
                break;
            case "world":
                System.out.println("Case world");
                break;
            default:
                System.out.println("Default case");
        }
    }
    
    public static void main(String[] args) {
        // String literal
        switchString("hello");
        
        // String from pool
        String s1 = "hello";
        switchString(s1);
        
        // New String - equals() kullanılır
        String s2 = new String("hello");
        switchString(s2);
        
        // Null - NullPointerException
        try {
            switchString(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException in switch");
        }
        
        // Switch uses equals() internally, not ==
        // But hash code optimization is used
    }
}

// ÇIKTI:
// Case hello
// Case hello
// Case hello
// NullPointerException in switch
// Switch statement String için equals() kullanır (Java 7+)
// Null String switch'te NullPointerException fırlatır


