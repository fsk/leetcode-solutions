package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 98: Polymorphism ve reflection ultimate
 * 
 * Reflection ile method invocation
 * Polymorphism ve type erasure
 * Çıktı ne olur?
 */
import java.lang.reflect.Method;

class OOP98A {
    void method(String s) {
        System.out.println("A method(String): " + s);
    }
    
    void method(Object o) {
        System.out.println("A method(Object): " + o);
    }
}

class OOP98B extends OOP98A {
    @Override
    void method(String s) {
        System.out.println("B method(String): " + s);
    }
    
    void method(Integer i) {
        System.out.println("B method(Integer): " + i);
    }
}

public class OOP98 {
    public static void main(String[] args) throws Exception {
        OOP98A obj = new OOP98B();
        
        // Normal invocation
        obj.method("test");
        obj.method((Object) "test");
        
        // Reflection invocation
        Method method1 = OOP98B.class.getMethod("method", String.class);
        method1.invoke(obj, "reflection");
        
        Method method2 = OOP98B.class.getMethod("method", Integer.class);
        method2.invoke(obj, 10);
        
        Method method3 = OOP98A.class.getMethod("method", Object.class);
        method3.invoke(obj, "object");
    }
}

// ÇIKTI:
// B method(String): test (runtime tip)
// B method(Object): test (runtime tip, override edilmiş)
// B method(String): reflection
// B method(Integer): 10
// B method(Object): object
// Reflection ile runtime'da metod çağrılır, polymorphism çalışır


