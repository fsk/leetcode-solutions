package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 24: String immutability trick
 * 
 * String immutable olduğu için ne olur?
 * Reference vs value
 * Çıktı ne olur?
 */
public class Basic24 {
    static void modifyString(String str) {
        str = str + " modified"; // Yeni String oluşturulur
        System.out.println("Inside method: " + str);
    }
    
    static void modifyStringBuilder(StringBuilder sb) {
        sb.append(" modified"); // Aynı object değiştirilir
        System.out.println("Inside method: " + sb);
    }
    
    public static void main(String[] args) {
        String s1 = "hello";
        modifyString(s1);
        System.out.println("After method: " + s1); // Değişmedi!
        
        StringBuilder sb = new StringBuilder("hello");
        modifyStringBuilder(sb);
        System.out.println("After method: " + sb); // Değişti!
        
        // String operations create new objects
        String s2 = "test";
        String s3 = s2.toUpperCase(); // Yeni String
        System.out.println("s2: " + s2); // "test"
        System.out.println("s3: " + s3); // "TEST"
        
        s2 = s2.concat("123"); // Yeni String, s2 değişmedi
        System.out.println("s2 after concat: " + s2); // "test"
    }
}

// ÇIKTI:
// Inside method: hello modified
// After method: hello (değişmedi - immutable)
// Inside method: hello modified
// After method: hello modified (değişti - mutable)
// s2: test
// s3: TEST
// s2 after concat: test
// String immutable, tüm işlemler yeni String oluşturur
// Reference değişmez, yeni object oluşturulur




