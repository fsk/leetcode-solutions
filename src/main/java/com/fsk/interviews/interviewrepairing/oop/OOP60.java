package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 60: Null ve varargs trick
 * 
 * Varargs metoduna null geçilebilir mi?
 * Null array vs null element farkı nedir?
 * Çıktı ne olur?
 */
class OOP60Test {
    void method(String... args) {
        if (args == null) {
            System.out.println("args is null");
        } else {
            System.out.println("args length: " + args.length);
            for (String arg : args) {
                System.out.println("arg: " + arg);
            }
        }
    }
}

public class OOP60 {
    public static void main(String[] args) {
        OOP60Test test = new OOP60Test();
        
        test.method(); // Empty varargs
        test.method((String[]) null); // Null array
        test.method((String) null); // Single null element
        test.method("a", "b", null); // Multiple elements with null
    }
}

// ÇIKTI:
// args length: 0
// args is null
// args length: 1
// arg: null
// args length: 3
// arg: a
// arg: b
// arg: null
// Varargs'a null geçilebilir, null array vs null element farklıdır


