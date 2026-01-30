package com.fsk.interviews.interviewrepairing.basicconcepts;

/**
 * SORU 40: Operator overloading yok ama trick var
 * 
 * Java'da operator overloading yok
 * Ama + operator String için özel
 * Çıktı ne olur?
 */
public class Basic40 {
    public static void main(String[] args) {
        // + operator String için "overloaded"
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + s2; // String concatenation
        System.out.println("s3: " + s3);
        
        // + operator numeric için arithmetic
        int a = 10;
        int b = 20;
        int sum = a + b; // Arithmetic addition
        System.out.println("sum: " + sum);
        
        // Mixed: String + number
        String result = "Sum: " + (a + b); // Arithmetic first, then concatenation
        System.out.println("result: " + result);
        
        // No operator overloading for custom classes
        // CustomClass obj1 + obj2; // HATA! Operator overloading yok
        
        // But StringBuilder has append()
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" ").append("World");
        System.out.println("sb: " + sb);
        
        // == operator always reference comparison for objects
        String str1 = "test";
        String str2 = new String("test");
        System.out.println("str1 == str2: " + (str1 == str2)); // false (reference)
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true (content)
    }
}

// ÇIKTI:
// s3: HelloWorld
// sum: 30
// result: Sum: 30
// sb: Hello World
// str1 == str2: false
// str1.equals(str2): true
// Java'da operator overloading yok (String + hariç)
// == her zaman reference karşılaştırması yapar (primitive hariç)




