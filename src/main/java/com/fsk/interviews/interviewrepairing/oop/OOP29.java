package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 29: Method reference ve lambda expression
 * 
 * Method reference ve lambda expression arasındaki fark nedir?
 * Hangi durumda hangisi kullanılır?
 * Çıktı ne olur?
 */
interface OOP29Interface {
    void method(String s);
}

class OOP29Test {
    static void staticMethod(String s) {
        System.out.println("Static: " + s);
    }
    
    void instanceMethod(String s) {
        System.out.println("Instance: " + s);
    }
}

public class OOP29 {
    public static void main(String[] args) {
        // Lambda expression
        OOP29Interface lambda = s -> System.out.println("Lambda: " + s);
        lambda.method("test1");
        
        // Method reference - static method
        OOP29Interface staticRef = OOP29Test::staticMethod;
        staticRef.method("test2");
        
        // Method reference - instance method
        OOP29Test test = new OOP29Test();
        OOP29Interface instanceRef = test::instanceMethod;
        instanceRef.method("test3");
        
        // Method reference - constructor
        OOP29Interface constructorRef = String::new;
        constructorRef.method("test4");
    }
}

// ÇIKTI:
// Lambda: test1
// Static: test2
// Instance: test3
// (String constructor çağrılır)
// Method reference daha kısa ve okunabilir, lambda daha esnek


