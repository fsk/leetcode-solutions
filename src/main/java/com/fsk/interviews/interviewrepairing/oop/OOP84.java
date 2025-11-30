package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 84: Polymorphism ve reflection trick
 * 
 * Reflection ile polymorphism
 * Method invocation ve type erasure
 * Çıktı ne olur?
 */
import java.lang.reflect.Method;

class OOP84A {
    void method(String s) {
        System.out.println("A method(String): " + s);
    }
}

class OOP84B extends OOP84A {
    @Override
    void method(String s) {
        System.out.println("B method(String): " + s);
    }
    
    void method(Integer i) {
        System.out.println("B method(Integer): " + i);
    }
}

public class OOP84 {
    public static void main(String[] args) throws Exception {
        OOP84A obj = new OOP84B();
        
        // Normal invocation
        obj.method("test");
        
        // Reflection invocation
        Method method = OOP84B.class.getMethod("method", String.class);
        method.invoke(obj, "reflection");
        
        // Method(Integer) görünmüyor çünkü compile-time tip OOP84A
        Method method2 = OOP84B.class.getMethod("method", Integer.class);
        method2.invoke(obj, 10);
    }
}

// ÇIKTI:
// B method(String): test
// B method(String): reflection
// B method(Integer): 10
// Reflection ile runtime'da metod çağrılabilir, polymorphism çalışır


