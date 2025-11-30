package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 87: Null ve varargs extreme case
 * 
 * Varargs null handling
 * Null array vs null elements
 * Çıktı ne olur?
 */
class OOP87Test {
    void method(Object... args) {
        if (args == null) {
            System.out.println("args is null");
            return;
        }
        System.out.println("args length: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i] + 
                " (null: " + (args[i] == null) + ")");
        }
    }
    
    void method2(String s, Object... args) {
        System.out.println("s = " + s);
        if (args != null) {
            System.out.println("args length: " + args.length);
        } else {
            System.out.println("args is null");
        }
    }
}

public class OOP87 {
    public static void main(String[] args) {
        OOP87Test test = new OOP87Test();
        
        test.method(); // Empty
        test.method((Object[]) null); // Null array
        test.method(null); // Single null element
        test.method(null, null); // Multiple null elements
        test.method("a", null, "b"); // Mixed
        
        test.method2("test"); // Empty varargs
        test.method2("test", (Object[]) null); // Null varargs
        test.method2("test", null); // Single null
    }
}

// ÇIKTI:
// args length: 0
// args is null
// args length: 1
// args[0] = null (null: true)
// args length: 2
// args[0] = null (null: true)
// args[1] = null (null: true)
// args length: 3
// args[0] = a (null: false)
// args[1] = null (null: true)
// args[2] = b (null: false)
// s = test
// args length: 0
// s = test
// args is null
// s = test
// args length: 1
// Varargs null handling dikkatli yapılmalı


