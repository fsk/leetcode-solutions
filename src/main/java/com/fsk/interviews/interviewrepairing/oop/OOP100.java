package com.fsk.interviews.interviewrepairing.oop;

/**
 * SORU 100: Ultimate OOP challenge - All concepts combined
 * 
 * Null + Polymorphism + Inheritance + Interface + Abstract Class
 * Method Overloading + Overriding + Hiding
 * Constructor Chain + Field Initialization
 * Çıktı ne olur?
 */
interface OOP100A {
    default void method(Object o) {
        System.out.println("A default method(Object)");
    }
}

abstract class OOP100B {
    String name = getName();
    
    OOP100B() {
        System.out.println("B constructor, name = " + name);
        method(null);
    }
    
    String getName() {
        return "B";
    }
    
    void method(Object o) {
        System.out.println("B method(Object): " + o);
    }
    
    abstract void abstractMethod();
}

class OOP100C extends OOP100B implements OOP100A {
    String name = getName();
    
    OOP100C() {
        System.out.println("C constructor, name = " + name);
        method(null);
    }
    
    String getName() {
        return "C";
    }
    
    @Override
    public void method(Object o) {
        System.out.println("C method(Object): " + o);
    }
    
    void method(String s) {
        System.out.println("C method(String): " + s);
    }
    
    @Override
    void abstractMethod() {
        System.out.println("C abstractMethod()");
    }
}

public class OOP100 {
    public static void main(String[] args) {
        OOP100B obj = new OOP100C();
        obj.method(null);
        obj.abstractMethod();
        
        OOP100A objA = (OOP100C) obj;
        objA.method(null);
        
        OOP100C objC = (OOP100C) obj;
        objC.method(null);
        objC.method((String) null);
    }
}

// ÇIKTI:
// B getName() (B için name)
// B constructor, name = B
// C method(Object): null (runtime tip)
// C getName() (C için name)
// C constructor, name = C
// C method(Object): null
// C method(Object): null (runtime tip)
// C abstractMethod()
// C method(Object): null
// C method(Object): null (compile-time tip C, method(Object) var)
// C method(String): null (compile-time tip C, method(String) var)
// Ultimate challenge: Tüm OOP konseptleri bir arada!


